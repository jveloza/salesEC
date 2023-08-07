package com.sales.app.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Immutable;

@Immutable
public final class PriceResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private final Long product_id;
	private final Long brand_id;
	private final Double price;
	private final String curr;
	private final LocalDateTime start_date;
	private final LocalDateTime end_date;
	
	public PriceResponse(Long product_id, Long brand_id, Double price, String curr, LocalDateTime start_date,
			LocalDateTime end_date) {
		super();
		this.product_id = product_id;
		this.brand_id = brand_id;
		this.price = price;
		this.curr = curr;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public Long getBrand_id() {
		return brand_id;
	}

	public Double getPrice() {
		return price;
	}

	public String getCurr() {
		return curr;
	}

	public LocalDateTime getStart_date() {
		return start_date;
	}

	public LocalDateTime getEnd_date() {
		return end_date;
	}
}