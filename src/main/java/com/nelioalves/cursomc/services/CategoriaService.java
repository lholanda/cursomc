package com.nelioalves.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

/*
 * Esta classe server metodo find() irá retornar sempre um objeto tipo 
 * categoria para quem requisitou no caso aqui foi o REST das categorias
 * 
 */
@Service
public class CategoriaService {

	@Autowired // aqui vai injetar repo dentro da Categoria
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Categoria obj = repo.findOne(id);
		// utilizar o meu proprio pacote ObjectNotFoundException
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Categoria.class.getName().substring(30));
		}
		return obj;  
	}

}
