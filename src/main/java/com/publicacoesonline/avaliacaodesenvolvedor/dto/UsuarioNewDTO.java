package com.publicacoesonline.avaliacaodesenvolvedor.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.publicacoesonline.avaliacaodesenvolvedor.entities.Processo;
import com.publicacoesonline.avaliacaodesenvolvedor.entities.Reu;
import com.publicacoesonline.avaliacaodesenvolvedor.entities.Usuario;

public class UsuarioNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 2, max=80, message = "O tamanho deve ser entre 2 e 80 caracteres")
	private String nome;
	@Email
	private String email;
	private String senha;
	@Column(unique = true)
	private Integer codigoProcesso;
	@NotEmpty(message = "Esse campo não pode ser vazio")
	private String nomeReu;
	@Column(unique = true)
	@CPF
	@NotEmpty(message = "Esse campo não pode ser vazio")
	private String cpfReu;
	
	public UsuarioNewDTO() {
		
	}
	
	public UsuarioNewDTO(Usuario usuario, Processo proceso, Reu reu) {
		id = usuario.getId();
		nome = usuario.getNome();
		email = usuario.getEmail();
		senha = usuario.getSenha();
		codigoProcesso = proceso.getCodigoProcesso();
		nomeReu = reu.getNomeReu();
		cpfReu = reu.getCpfReu();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getCodigoProcesso() {
		return codigoProcesso;
	}

	public void setCodigoProcesso(Integer codigoProcesso) {
		this.codigoProcesso = codigoProcesso;
	}

	public String getNomeReu() {
		return nomeReu;
	}

	public void setNomeReu(String nomeReu) {
		this.nomeReu = nomeReu;
	}

	public String getCpfReu() {
		return cpfReu;
	}

	public void setCpfReu(String cpfReu) {
		this.cpfReu = cpfReu;
	}

	
}
