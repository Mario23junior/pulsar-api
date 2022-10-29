package com.project.pulsar.modelErro;

public class ModelErroReturn {

	private String field;
	private String message;

	public ModelErroReturn(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}

	public ModelErroReturn() {
		// TODO Auto-generated constructor stub
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
