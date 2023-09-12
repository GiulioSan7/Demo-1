package com.giulio.sannino.bean;


public class Person {
	
	private String cognome;
	private String name;
	private String citta;
	private String codiceFiscale;
	
	public Person(String cognome, String name, String citta, String codiceFiscale) {
		this.cognome=cognome;
		this.name=name;
		this.citta=citta;
		this.codiceFiscale=codiceFiscale;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}


	

}

