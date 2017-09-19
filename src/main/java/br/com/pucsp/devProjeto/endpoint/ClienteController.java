package br.com.pucsp.devProjeto.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pucsp.devProjeto.modelo.ClienteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="Clientes API")
@RestController
@RequestMapping("/v1")
public class ClienteController {
	@ApiOperation(value="Consulta todos clientes do sistema", notes="Consulta síncrona.")
	  @RequestMapping(value="/clientes", method = RequestMethod.GET)
	  public ResponseEntity consultaClientes() {
	        return ResponseEntity.status(HttpStatus.OK).body("Consulta de clientes executada com sucesso!");
	  }
	 
	  @ApiOperation(value="Consulta um cliente no sistema", notes="Consulta síncrona.")
	  @RequestMapping(value="/clientes/{clienteId}", method = RequestMethod.GET)
	  public ResponseEntity consultaClientesPorId(@ApiParam(value="Id do cliente")
	                                                      @PathVariable Long clienteId) {
	 
	        return  ResponseEntity.status(HttpStatus.OK).body("Consulta executada com sucesso! Id=" + clienteId);
	  }
	 
	  @ApiOperation(value="Cria um novo cliente.", notes="Inserção síncrona.")
	  @RequestMapping(value="/clientes", method = RequestMethod.POST)
	  public ResponseEntity criarCliente(@RequestBody ClienteDTO clienteDTO) {
	       return ResponseEntity.status(HttpStatus.CREATED).body("Inserido com sucesso!");
	  }
}
