package com.sales.app.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prices")
public class Prices implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "brand_id", referencedColumnName = "id")
	private Brand brand;
	
	@Column
	private LocalDateTime start_date;
	
	@Column
	private LocalDateTime end_date;
	
	@Column
	private Integer price_list;
	
	@OneToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;
	
	@Column
	private Boolean priority;
	
	@Column
	private Double price;
	
	@Column
	private String curr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand_id(Brand brand) {
		this.brand = brand;
	}

	public LocalDateTime getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDateTime start_date) {
		this.start_date = start_date;
	}

	public LocalDateTime getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDateTime end_date) {
		this.end_date = end_date;
	}

	public Integer getPrice_list() {
		return price_list;
	}

	public void setPrice_list(Integer price_list) {
		this.price_list = price_list;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Boolean getPriority() {
		return priority;
	}

	public void setPriority(Boolean priority) {
		this.priority = priority;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}
	
}
