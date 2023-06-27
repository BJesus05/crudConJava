package com.crudV2.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crudV2.interfaceServices.InterfaceExistenciasService;
import com.crudV2.modelo.Existencia;


@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private InterfaceExistenciasService service;
	@GetMapping("/")
	public String index(Model model) {
		return "redirect:/listar";
	}
		
	@GetMapping("/listar")
	public String listar(Model model) {
		
		List<Existencia>existencia = service.listar();
		model.addAttribute("existencia",existencia);
		return "index.html";
	}
	
	@GetMapping("/nuevo")
	public String agregar(Model model) {
		model.addAttribute("existencia", new Existencia());
		return "formulario";
	}
	
	@PostMapping("/savee")
	public String save(Existencia existencia,Model model) {
		System.out.println("Exi:" + existencia);
		service.save(existencia);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Existencia>existencia=service.listarId(id);
		model.addAttribute("existencia",existencia);
		return "formulario";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);		
		 return "redirect:/listar";
	}
	
	
}
