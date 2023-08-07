package com.sales.app.request;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Immutable;

@Immutable
public final class PriceRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotNull
	private final Long brand_id;
	
	@NotEmpty
	private final String start_date;
	
	@NotNull
	private final Long product_id;
	
	public PriceRequest(@NotEmpty Long brand_id, @NotEmpty String start_date, @NotEmpty Long product_id) {
		super();
		this.brand_id = brand_id;
		this.start_date = start_date;
		this.product_id = product_id;
	}

	public Long getBrand_id() {
		return brand_id;
	}

	public String getStart_date() {
		return start_date;
	}

	public Long getProduct_id() {
		return product_id;
	}
}