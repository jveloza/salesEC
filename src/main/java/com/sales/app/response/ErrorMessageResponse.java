package com.sales.app.response;

import org.springframework.data.annotation.Immutable;

@Immutable
public class ErrorMessageResponse {

	private final String errorMessage;

	public ErrorMessageResponse(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}