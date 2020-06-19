package com.produtos.apirest.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Essa classe vai ser uma entidade(@Entity) do banco de dados


@Entity
@Table(name="TB_PRODUTO")
//O (TB_PRODUTO) vai ser o nome da tabela no banco de dados
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	//O GenerateValue é para gerar o id automaticamente
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	
	private String nome;
	
	private BigDecimal quantidade;
	
	private BigDecimal valor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
// no application.properties (jdbc:postgresql://localhost:5432/produtos-apirest) o produtos-apirest é o nome de uma 
//base de dados que foi criado no postgresql	
	
}
