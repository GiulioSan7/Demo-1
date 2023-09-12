package com.giulio.sannino.bean;

public class Pizza {

	private Integer codiceOrdine;
	private boolean statoOrdine;
	private String nomeCliente;
	private String nomePizza;

	public Pizza(Integer codiceOrdine, boolean statoOrdine, String nomeCliente,String nomePizza) {
		this.codiceOrdine = codiceOrdine;
		this.statoOrdine = statoOrdine;
		this.nomeCliente = nomeCliente;
		this.nomePizza= nomePizza;
	}

	public boolean isStatoOrdine() {
		return statoOrdine;
	}

	public void setStatoOrdine(boolean statoOrdine) {
		this.statoOrdine = statoOrdine;
	}

	public Integer getCodiceOrdine() {
		return codiceOrdine;
	}

	public void setCodiceOrdine(Integer codiceOrdine) {
		this.codiceOrdine = codiceOrdine;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomePizza() {
		return nomePizza;
	}

	public void setNomePizza(String nomePizza) {
		this.nomePizza = nomePizza;
	}
}
