package com.publicacoesonline.avaliacaodesenvolvedor.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reu implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "Esse campo não pode ser vazio")
	private String nome;
	@Column(unique = true)
	@CPF
	@NotEmpty(message = "Esse campo não pode ser vazio")
	private String cpf;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "processo_id")
	private Processo processo;
	
	public Reu() {
		
	}

	public Reu(Integer id, @NotEmpty(message = "Esse campo não pode ser vazio") String nome,
			@CPF @NotEmpty(message = "Esse campo não pode ser vazio") String cpf, Processo processo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.processo = processo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reu other = (Reu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
