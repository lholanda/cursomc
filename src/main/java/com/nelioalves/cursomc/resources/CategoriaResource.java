package com.nelioalves.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.services.CategoriaService;

/*
 * Controlador REST da classe categorias.
 */
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired // aqui vai injetar service dentro da Categoria
	private CategoriaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		// ENCONTRAR UMA CATEGORIA COM O id

		Categoria obj = service.find(id); // injetado
		return ResponseEntity.ok().body(obj);
	}
}
