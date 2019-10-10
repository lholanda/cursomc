package com.nelioalves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;

// implements ComandLineRunner, faz com que seja rodado automaticamente
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	// criar uma dependenca do repository aqui que será injetada nesta classe 
	// CursoApplication
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Metodo auxIliar quando a aplicacao iniciar
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");	
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); 
	}

}
