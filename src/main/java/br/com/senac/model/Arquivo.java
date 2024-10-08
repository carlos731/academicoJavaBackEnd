package br.com.senac.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.senac.model.Enums.ArquivoStatus;

@Entity
@Table(name = "arquivo")
public class Arquivo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "arquivo_id")
	private Integer id;
	
	@Column(name = "arquivo_descricao")
	private String Descricao;
	
	@Column(name = "arquivo_nome_arquivo")
	private String nomeArquivo;
	
	@Column(name = "arquivo_atividade_extensao")
	private String extensao;
	
	@Column(name = "arquivo_size")
	private Long fileSize;
	
	@Column(name = "arquivo_data_cadastro")
	private Date dataCadastro = new Date();
	
	@Lob
	@Column(name = "arquivo_blob", columnDefinition="longblob")
	private byte[] blob;
	
	@Column(name = "arquivo_status")
	private ArquivoStatus status;
	
	@ManyToMany
	@JoinTable(
		name = "arquivo_atividade",
		joinColumns = { @JoinColumn(name = "arquivo_id", referencedColumnName = "arquivo_id")},
		inverseJoinColumns = { @JoinColumn(name = "atividade_id", referencedColumnName = "atividade_id")} 
	)
	@Column(name = "atividades")
	private List<Atividade> atividades;

	public Arquivo() {
		super();
	}

	public Arquivo(Integer id, String descricao, String nomeArquivo, String extensao, Long fileSize, Date dataCadastro,
			byte[] blob, ArquivoStatus status) {
		super();
		this.id = id;
		Descricao = descricao;
		this.nomeArquivo = nomeArquivo;
		this.extensao = extensao;
		this.fileSize = fileSize;
		this.dataCadastro = dataCadastro;
		this.blob = blob;
		this.status = status;
	}

	public Arquivo(String descricao, String nomeArquivo, String extensao, Long fileSize, Date dataCadastro, byte[] blob,
			ArquivoStatus status) {
		super();
		Descricao = descricao;
		this.nomeArquivo = nomeArquivo;
		this.extensao = extensao;
		this.fileSize = fileSize;
		this.dataCadastro = dataCadastro;
		this.blob = blob;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public byte[] getBlob() {
		return blob;
	}

	public void setBlob(byte[] blob) {
		this.blob = blob;
	}

	public ArquivoStatus getStatus() {
		return status;
	}

	public void setStatus(ArquivoStatus status) {
		this.status = status;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	
	
}
