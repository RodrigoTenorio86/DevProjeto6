package br.com.pucsp.devProjeto.endpoint;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pucsp.devProjeto.error.ResourceNotFoundException;
import br.com.pucsp.devProjeto.modelo.Estudante;
import br.com.pucsp.devProjeto.repository.EstudanteRepository;
import io.swagger.annotations.ApiOperation;
import javassist.bytecode.ExceptionsAttribute;

@RestController
@RequestMapping("v1")
public class EstudanteRestController {
	private final EstudanteRepository dao;

	@Autowired
	public EstudanteRestController(EstudanteRepository dao) {	this.dao = dao;	}

	@GetMapping(path = "/estudantes")
	@ApiOperation(value = "return a list with all Estudante", response = Estudante[].class)
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/estudantes/{id}")
	@ApiOperation(value = "getEstudanteById", response = Estudante.class)
	public ResponseEntity<?> getEstudanteById(@PathVariable("id") Long id) {
		verifyIfEstudanteExists(id);
		return new ResponseEntity<>(dao.findOne(id), HttpStatus.OK);
	}

	@GetMapping(path = "/estudantes/nome/{nome}")
	@ApiOperation(value = "findEstudanteByName", response = Estudante[].class)
	public ResponseEntity<?> findEstudanteByName(@PathVariable("nome") String nome) {
		return new ResponseEntity<>(dao.findByNomeIgnoreCaseContaining(nome), HttpStatus.OK);
	}

	@DeleteMapping(path = "/estudantes/{id}")
	@Transactional(rollbackFor=Exception.class)
	@ApiOperation(value = "Delete")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		verifyIfEstudanteExists(id);
		dao.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(path="/estudantes")
	@Transactional(rollbackFor=Exception.class)
	@ApiOperation(value="Save",response=Estudante.class)
	public ResponseEntity<?> save(@Valid @RequestBody Estudante estudante) {
		return new ResponseEntity<>(dao.save(estudante), HttpStatus.CREATED);
	}

	@PutMapping(path="/estudantes")
	@Transactional(rollbackFor=Exception.class)
	public ResponseEntity<?>update(@Valid @RequestBody Estudante estudante){
		verifyIfEstudanteExists(estudante.getId());
		dao.save(estudante);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void verifyIfEstudanteExists(Long id) {
		if (dao.findOne(id) == null)
			throw new ResourceNotFoundException("Estudante Not Found for id " + id);
	}
}
