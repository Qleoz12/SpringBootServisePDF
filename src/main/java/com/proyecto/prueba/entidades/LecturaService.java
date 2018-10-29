package com.proyecto.prueba.entidades;


public class LecturaService {

	private String resguardoIndigena;
	private String nombreSenior;
	private String numeroDocumento;
	private String AnosSensos;
	private String LugaryFechaExpedido;
	private String urlVerificacion;

	public String getResguardoIndigena() {
		return resguardoIndigena;
	}

	public void setResguardoIndigena(String resguardoIndigena) {
		this.resguardoIndigena = resguardoIndigena;
	}

	public String getNombreSenior() {
		return nombreSenior;
	}

	public void setNombreSenior(String nombreSenior) {
		this.nombreSenior = nombreSenior;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getAnosSensos() {
		return AnosSensos;
	}

	public void setAnosSensos(String anosSensos) {
		AnosSensos = anosSensos;
	}

	public String getLugaryFechaExpedido() {
		return LugaryFechaExpedido;
	}

	public void setLugaryFechaExpedido(String lugaryFechaExpedido) {
		LugaryFechaExpedido = lugaryFechaExpedido;
	}

	public String getUrlVerificacion() {
		return urlVerificacion;
	}

	public void setUrlVerificacion(String urlVerificacion) {
		this.urlVerificacion = urlVerificacion;
	}

	public LecturaService(String resguardoIndigena, String nombreSenior, String numeroDocumento, String anosSensos,
			String lugaryFechaExpedido, String urlVerificacion) {
		super();
		this.resguardoIndigena = resguardoIndigena;
		this.nombreSenior = nombreSenior;
		this.numeroDocumento = numeroDocumento;
		AnosSensos = anosSensos;
		LugaryFechaExpedido = lugaryFechaExpedido;
		this.urlVerificacion = urlVerificacion;
	}

	@Override
	public String toString() {
		return "LecturaService [resguardoIndigena=" + resguardoIndigena + ", nombreSenior=" + nombreSenior
				+ ", numeroDocumento=" + numeroDocumento + ", AnosSensos=" + AnosSensos + ", LugaryFechaExpedido="
				+ LugaryFechaExpedido + ", urlVerificacion=" + urlVerificacion + "]";
	}

}
