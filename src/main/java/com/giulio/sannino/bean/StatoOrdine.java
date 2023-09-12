package com.giulio.sannino.bean;

public class StatoOrdine {
	private Integer codiceOrdine;
	private String nomeCliente;
	private boolean statoOrdine;
	private String messageOrdine;
	private String nomePizza;

	public StatoOrdine() {

	}

	public StatoOrdine(Integer codiceOrdine, String nomeCliente, boolean statoOrdine, String messageOrdine,
			String nomePizza) {
		this.codiceOrdine = codiceOrdine;
		this.statoOrdine = statoOrdine;
		this.nomeCliente = nomeCliente;
		this.messageOrdine = messageOrdine;
		this.nomePizza = nomePizza;
	}

	public Integer getCodiceOrdine() {
		return codiceOrdine;
	}

	public void setCodiceOrdine(Integer codiceOrdine) {
		this.codiceOrdine = codiceOrdine;
	}

	public boolean isStatoOrdine() {
		return statoOrdine;
	}

	public void setStatoOrdine(boolean statoOrdine) {
		this.statoOrdine = statoOrdine;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getMessageOrdine() {
		return messageOrdine;
	}

	public void setMessageOrdine(String messageOrdine) {
		this.messageOrdine = messageOrdine;
	}

	public String getNomePizza() {
		return nomePizza;
	}

	public void setNomePizza(String nomePizza) {
		this.nomePizza = nomePizza;
	}
}
