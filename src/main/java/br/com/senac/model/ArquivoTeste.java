package br.com.senac.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "arquivo_teste")
public class ArquivoTeste {
	
	//@Id
    //@GeneratedValue(generator = "uuid")
    //@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "arquivo_id")
	private Integer id;
	@Column(name = "arquivo_nome")
	private String fileName;
	@Column(name = "arquivo_tipo")
	private String fileType;
	@Column(name = "arquivo_size")
	private long fileSize;
	@Lob
	@Column(name = "arquivo_blob")
	private byte[] data;
	@Column(name = "arquivo_time")
	private Date time = new Date();
	@Column(name = "arquivo_url")
	private String url;
	
	public ArquivoTeste() {
		super();
	}

	public ArquivoTeste(Integer id, String fileName, String fileType, Long fileSize, byte[] data, Date time, String url) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.data = data;
		this.time = time;
		this.url = url;
	}
	
	public ArquivoTeste(String fileName, String fileType, Long fileSize, byte[] data, Date time, String url) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.data = data;
		this.time = time;
		this.url = url;
	}

	public ArquivoTeste(String fileName, String fileType, Long fileSize, byte[] data, Date time) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.data = data;
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
