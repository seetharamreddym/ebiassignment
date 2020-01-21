package com.ebi.person.model;

public class ApplicationError {
	
	private String type;
	
	private String title;

	private String description;
	
	private int  status;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	
	public ApplicationError(final String type, final String title, final String description, final int  status) {
		this.type = type;
		this.title = title;
		this.description =description;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}


}
