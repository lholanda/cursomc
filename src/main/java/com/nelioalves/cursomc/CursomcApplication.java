package com.nelioalves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.domain.enums.TipoCliente;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.repositories.EnderecoRepository;
import com.nelioalves.cursomc.repositories.EstadoRepository;
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
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Metodo auxiliar quando a aplicacao iniciar

		// CATEGORIAS E PRODUTOS
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");	
		
		Produto   p1   = new Produto(null, "Computador", 2000.00);
		Produto   p2   = new Produto(null, "Impressora", 800.00);
		Produto   p3   = new Produto(null, "Mouse", 80.00);
		// Categorias Associacoes
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		// Produtos Associacoes
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		// salvar
		categoriaRepository.save(Arrays.asList(cat1, cat2)); 
		produtoRepository.save(Arrays.asList(p1, p2, p3));
		
		// ESTADOS E CIDADES
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		// Cidades tem que conhecer os estados
		Cidade c1 = new Cidade(null, "Uberlândia",est1);
		Cidade c2 = new Cidade(null, "São Paulo" ,est2);
		Cidade c3 = new Cidade(null, "Campinas"  ,est2);
		// Estados devem conhecer as cidades
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		// salvar
		estadoRepository.save(Arrays.asList(est1, est2)); 
		cidadeRepository.save(Arrays.asList(c1, c2, c3));
		
		// CLIENTES
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		// ENDERECOS
		Endereco e1 = new Endereco(null, "Rua das Flores", "300","Apto 203","Jardim","38220834",cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos" , "105","Sala 800","Centro","38220834",cli1, c2);
		// clientes tem que conhecer os enderecos dele
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		// sempre tem que salvar por primeiro quem for independente
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1,e2));
	}

}

//new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
