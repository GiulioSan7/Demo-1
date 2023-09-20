package com.giulio.sannino.bean;

public class Prodotto {
	private Integer id;
	private String nomeProdotto;
	private String descrizioneP;
	private Integer annoDiProduzione;
	private boolean prodottoUsato;
	private Integer quantitàMagazzino;
	private Integer quantitaDaVendere;
	public Prodotto() {
		
	}

	public Prodotto(Integer id, String nomeProdotto, String descrizioneP, Integer annoDiProduzione,
			boolean prodottoUsato, Integer quantitàMagazzino,Integer quantitaDaVendere) {
		this.id = id;
		this.nomeProdotto = nomeProdotto;
		this.descrizioneP = descrizioneP;
		this.annoDiProduzione = annoDiProduzione;
		this.prodottoUsato = prodottoUsato;
		this.quantitàMagazzino = quantitàMagazzino;
		this.quantitaDaVendere=quantitaDaVendere;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public String getDescrizioneP() {
		return descrizioneP;
	}

	public void setDescrizioneP(String descrizioneP) {
		this.descrizioneP = descrizioneP;
	}

	public Integer getAnnoDiProduzione() {
		return annoDiProduzione;
	}

	public void setAnnoDiProduzione(Integer annoDiProduzione) {
		this.annoDiProduzione = annoDiProduzione;
	}

	public boolean isProdottoUsato() {
		return prodottoUsato;
	}

	public void setProdottoUsato(boolean prodottoUsato) {
		this.prodottoUsato = prodottoUsato;
	}

	public Integer getQuantitàMagazzino() {
		return quantitàMagazzino;
	}

	public void setQuantitàMagazzino(Integer quantitàMagazzino) {
		this.quantitàMagazzino = quantitàMagazzino;
	}

	public Integer getQuantitaDaVendere() {
		return quantitaDaVendere;
	}

	public void setQuantitaDaVendere(Integer quantitaDaVendere) {
		this.quantitaDaVendere = quantitaDaVendere;
	}
}
