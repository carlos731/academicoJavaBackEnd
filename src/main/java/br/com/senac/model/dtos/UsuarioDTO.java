package br.com.senac.model.dtos;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import br.com.senac.model.Enums.Status;
import br.com.senac.model.Enums.UsuarioTipo;

public class UsuarioDTO {
	
	private Integer id;
	private String cpf;
	private String nomeCompleto;
	private String apelido;
	private String email;
	private Date dataNascimento;
	private String telefone;
	private LocalDate atendimentoDataCadastro = LocalDate.now();
	private byte[] foto;
	private String senha;
	private Set<UsuarioTipo> perfis = new HashSet<>();
	private Status status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDate getAtendimentoDataCadastro() {
		return atendimentoDataCadastro;
	}
	public void setAtendimentoDataCadastro(LocalDate atendimentoDataCadastro) {
		this.atendimentoDataCadastro = atendimentoDataCadastro;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Set<UsuarioTipo> getPerfis() {
		return perfis;
	}
	public void setPerfis(Set<UsuarioTipo> perfis) {
		this.perfis = perfis;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

}
