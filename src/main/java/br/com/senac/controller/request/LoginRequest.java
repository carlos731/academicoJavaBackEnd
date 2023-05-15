package br.com.senac.controller.request;

public class LoginRequest {
	
	private String email;
	private String senha;
		
	public LoginRequest() {
		super();
	}

	public LoginRequest(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
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

}
