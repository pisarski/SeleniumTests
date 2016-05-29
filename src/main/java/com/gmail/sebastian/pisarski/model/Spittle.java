package com.gmail.sebastian.pisarski.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Spittle {

	private String title;
	private String message;
	private String author;

	public Spittle() {
	}

	public Spittle(String title, String message) {
		this.title = title;
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(String.format(
				"title='%s', message='%s'", title, message));
		if (author != null) {
			builder.append(String.format(", autor='%s'", author));
		}
		return "{" + builder.toString() + "}";
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
