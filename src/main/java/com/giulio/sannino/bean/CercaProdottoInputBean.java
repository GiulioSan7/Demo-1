package com.giulio.sannino.bean;

public class CercaProdottoInputBean {
	private Integer id;
	private Integer quantitàMagazzino;
	private Integer quantitaDaVendere;
	public CercaProdottoInputBean() {
		
	}
	public CercaProdottoInputBean(Integer id,Integer quantitàMagazzino,Integer quantitaDaVendere) {
		this.id=id;
		this.quantitàMagazzino=quantitàMagazzino;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantitaMagazzino() {
		return quantitàMagazzino;
	}
	public void setQuantitaMagazzino(Integer quantitaMagazzino) {
		this.quantitàMagazzino = quantitaMagazzino;
	}
	public Integer getQuantitaDaVendere() {
		return quantitaDaVendere;
	}
	public void setQuantitaDaVendere(Integer quantitaDaVendere) {
		this.quantitaDaVendere = quantitaDaVendere;
	}
}
