package com.giulio.sannino.bean;

public class RispostaServer {
	private String message;
	public RispostaServer(String message) {
		this.setMessage(message);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
