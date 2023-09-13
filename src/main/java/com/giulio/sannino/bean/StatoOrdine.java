package com.giulio.sannino.bean;

public class StatoOrdine {
	private Integer codiceOrdine;
	private String nomeCliente;
	private Integer faseCasualeOrdine;
	private String messageOrdine;
	private String nomePizza;

	public StatoOrdine() {

	}

	public StatoOrdine(Integer codiceOrdine, String nomeCliente, Integer faseCasualeOrdine, String messageOrdine,String nomePizza) {
		this.codiceOrdine = codiceOrdine;
		this.faseCasualeOrdine = faseCasualeOrdine;
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

	public Integer getFaseCasualeOrdine() {
		return faseCasualeOrdine;
	}

	public void setFaseCasualeOrdine(Integer faseCasualeOrdine) {
		this.faseCasualeOrdine = faseCasualeOrdine;
//		switch (faseCasualeOrdine) {
//		case 1:
//			System.out.println("1 = In attesa");
//			break;
//		case 2:
//			System.out.println("2 = In preparazione.");
//			break;
//		case 3:
//			System.out.println("3 = Ordine effettuato.");
//			break;
//		default:
//			System.out.println("Valore casuale non gestito.");
//		}
	}
}
