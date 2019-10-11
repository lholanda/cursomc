package com.nelioalves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

// implements ComandLineRunner, faz com que seja rodado automaticamente
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	// criar uma dependenca do repository aqui que será injetada nesta classe 
	// CursoApplication
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Metodo auxIliar quando a aplicacao iniciar
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");	
		
		Produto   p1   = new Produto(null, "Computador", 2000.00);
		Produto   p2   = new Produto(null, "Impressora", 800.00);
		Produto   p3   = new Produto(null, "Mouse", 80.00);
	
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		// salva categorias
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); 
		// salva os produtos
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
