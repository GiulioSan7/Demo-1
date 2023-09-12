package com.giulio.sannino.bean;

public class Libro {
	private Integer id;
	private String titolo;
	private String autore;
	private Integer isbn;
	private String casaEditrice;
	private Integer numeroCopie;
	private Boolean borrow;

	public Libro(Integer id, String titolo, String autore, Integer isbn, String casaEditrice, Integer numeroCopie,Boolean borrow) {
		this.id = id;
		this.titolo = titolo;
		this.autore = autore;
		this.isbn = isbn;
		this.casaEditrice = casaEditrice;
		this.numeroCopie = numeroCopie;
		this.borrow=borrow;
		

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getCasaEditrice() {
		return casaEditrice;
	}

	public void setCasaEditrice(String casaEditrice) {
		this.casaEditrice = casaEditrice;
	}

	public Integer getNumeroCopie() {
		return numeroCopie;
	}

	public void setNumeroCopie(Integer numeroCopie) {
		this.numeroCopie = numeroCopie;
	}

	public Boolean getBorrow() {
		return borrow;
	}

	public void setBorrow(Boolean borrow) {
		this.borrow = borrow;
	}
}
