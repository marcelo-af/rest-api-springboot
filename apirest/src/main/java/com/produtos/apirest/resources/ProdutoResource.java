package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.produtos.apirest.models.Produto;

@RestController
@RequestMapping(value="/api")
//Anotação do titulo da Swagger @Api
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
//O @CrossOrigin com o * indica que qualquer dominio pode acessar a api
public class ProdutoResource {	
	//A classe ProdutoResources foi criada para poder listar os dados do banco de dados, atraves da chamada rest
	
@Autowired
ProdutoRepository produtoRepository;

@GetMapping("/produtos")
@ApiOperation(value="Retorna uma lista de produtos")
//O @ApiOperation retorna uma descrição que o metodo faz durante a exibição no Swagger
public List<Produto> listaProdutos(){

	return produtoRepository.findAll();
	//Criado o metodo listaProdutos onde pega os dados da classe produto e consulta 
		//no banco de dados atraves do produtoRepository
	
}


//Criando um metodo e uma URI(endpoint)para chamar apenas um produto do banco de dados
@GetMapping("/produto/{id}")
@ApiOperation(value="Retorna um produto de acordo com o seu id")
public Produto listarProdutoUnico(@PathVariable(value="id") long id) {
	//@PathVariable é para passar uma variavel no metodo
	return produtoRepository.findById(id);
}

@PostMapping("/produto")
@ApiOperation(value="Adiciona um produto")
public Produto salvaProduto(@RequestBody Produto produto) {
	return produtoRepository.save(produto);
	
	/*É criado o metodo Post para salvar novos dados no banco é necessário utilizar 
	 * o @RequestBody a classe Produto foi instanciada e criada o objeto produto */
}

@DeleteMapping("/produto")
//A URI acima ("/produto")pode ser mudada para ("/delete") se quiser para combinar com o metodo
@ApiOperation(value="Deleta um produto")
public void deletarProduto(@RequestBody Produto produto) {
	produtoRepository.delete(produto);
}

@PutMapping("/produto")
@ApiOperation(value="Atualiza um produto")
public Produto atualizaProduto(@RequestBody Produto produto) {

	return produtoRepository.save(produto);
}

}
