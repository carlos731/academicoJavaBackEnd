package br.com.senac.model.error;

public class ErrorMessage {
	
	private String titulo;
	private Integer Status;
	private String mensagem;
	
	public ErrorMessage(String titulo, Integer status, String mensagem) {
		super();
		this.titulo = titulo;
		Status = status;
		this.mensagem = mensagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
