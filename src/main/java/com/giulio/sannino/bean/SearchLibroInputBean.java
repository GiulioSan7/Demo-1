package com.giulio.sannino.bean;

public class SearchLibroInputBean {
	private Integer id;
	private Integer isbn;

	public SearchLibroInputBean(Integer id, Integer isbn) {
		this.id = id;
		this.setIsbn(isbn);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
}
