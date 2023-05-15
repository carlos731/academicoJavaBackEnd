package br.com.senac.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.senac.model.Enums.Status;
import br.com.senac.model.Enums.UsuarioTipo;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Integer id;
	//@CPF
	@Column(name = "usuario_cpf", unique = true)
	private String cpf;
	@Column(name = "usuario_nome_completo")
	private String nomeCompleto;
	@Column(name = "user_apelido")
	private String apelido;
	@Column(name = "usuario_email", unique = true)
	private String email;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "usuario_data_nascimento")
	private Date dataNascimento;
	@Column(name = "usuario_telefone")
	private String telefone;
	@Column(name = "atendimento_data_cadastro")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate atendimentoDataCadastro = LocalDate.now();
	@JsonIgnore
	@Lob
	@Column(name = "usuario_foto")
	private byte[] foto;	
	//@JsonIgnore
	@Column(name = "usuario_senha")
	private String senha;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "perfis")
	private Set<UsuarioTipo> perfis = new HashSet<>();
	@Column(name = "usuario_status")
	private Status status;
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id, String cpf, String nomeCompleto, String apelido, String email, Date dataNascimento,
			String telefone, LocalDate atendimentoDataCadastro, byte[] foto, String senha, Set<UsuarioTipo> perfis,
			Status status) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.apelido = apelido;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.atendimentoDataCadastro = atendimentoDataCadastro;
		this.foto = foto;
		this.senha = senha;
		this.perfis = perfis;
		this.status = status;
	}

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
