package com.ebi.person.exception;

import org.springframework.http.HttpStatus;

public class ApplicationException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	  private HttpStatus status;
	  
	  private String title;
	  
	  private String description;
	  
	  public ApplicationException(final HttpStatus status, final String title, final String description) {
		  
		  this.status =status;
		  this.title = title;
		  this.description = description;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
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

	
}
