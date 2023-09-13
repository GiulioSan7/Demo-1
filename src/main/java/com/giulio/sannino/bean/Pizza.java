package com.giulio.sannino.bean;



public class Pizza {

	private Integer codiceOrdine;
	private Integer statoOrdine;
	private String nomeCliente;
	private String nomePizza;
//	private Integer faseCasualeOrdine;
    private Integer faseCasualeOrdine;

	public Pizza(Integer codiceOrdine, Integer faseCasualeOrdine, String nomeCliente, String nomePizza) {
		this.codiceOrdine = codiceOrdine;
//		this.statoOrdine = statoOrdine;
		this.faseCasualeOrdine = faseCasualeOrdine;
		this.nomeCliente = nomeCliente;
		this.nomePizza = nomePizza;

	}

	public Integer isStatoOrdine() {
		return statoOrdine;
	}

	public void setStatoOrdine(Integer statoOrdine) {
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
