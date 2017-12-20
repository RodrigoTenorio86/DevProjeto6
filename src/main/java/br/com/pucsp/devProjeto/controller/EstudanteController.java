package br.com.pucsp.devProjeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.pucsp.devProjeto.modelo.Estudante;
import br.com.pucsp.devProjeto.repository.EstudanteRepository;

//@Controller
public class EstudanteController {
	//@Autowired
	private EstudanteRepository dao;

	public String index() {
		return "index";
	}

	//@RequestMapping(value = "/cadastrarEstudante", method = RequestMethod.GET)
	public String form() {
		return "view/formEstudante";
	}
	
	//@RequestMapping(value="/cadastrarEstudante", method=RequestMethod.POST )
	public String form(Estudante estudante) {
		dao.save(estudante);
		return "redirect:/cadastrarEstudante";
	}
	
	//@RequestMapping("/")
	public ModelAndView listaEstudante() {
		ModelAndView mv=new ModelAndView("index");
		Iterable<Estudante>estudantes=dao.findAll();
		mv.addObject("estudantes", estudantes);
		return mv;
	}
	
	//@RequestMapping("/{codigo}")
	public ModelAndView detalhesEstudante(@PathVariable("codigo")long codigo ) {
		Estudante estudante=dao.findOne(codigo);
		ModelAndView mv =new ModelAndView("evento/detalhesEstudante");
		mv.addObject("estudante", estudante);
		return mv;
	}
	
	

}
