package br.gov.caixa.sammp.dto;

public class MensagemErroDTO {
	private String codigo;
	private String severidade;
	private String texto;
	private Throwable error;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getSeveridade() {
		return severidade;
	}
	public void setSeveridade(String severidade) {
		this.severidade = severidade;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Throwable getError() {
		return error;
	}
	public void setError(Throwable error) {
		this.error = error;
	}
}
