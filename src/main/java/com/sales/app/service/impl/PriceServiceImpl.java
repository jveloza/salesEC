package com.sales.app.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.app.repository.PriceRepository;
import com.sales.app.request.PriceRequest;
import com.sales.app.response.PriceResponse;
import com.sales.app.service.IPriceService;

@Service
public class PriceServiceImpl implements IPriceService{

	@Autowired
	private PriceRepository priceRepository;
	
	@Override
	public PriceResponse findByBrandProductDate(PriceRequest priceRequest) throws NonUniqueResultException,DateTimeParseException{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime.parse(priceRequest.getStart_date(), formatter);
		var oPrice=priceRepository.findByBrandProductDate(priceRequest.getStart_date(),
				priceRequest.getBrand_id(),
				priceRequest.getProduct_id());				
		if(!oPrice.isPresent()) {
			return null;
		}
		return new PriceResponse(oPrice.get().getProduct().getId(), oPrice.get().getBrand().getId(),
				oPrice.get().getPrice(), oPrice.get().getCurr(), oPrice.get().getStart_date(), 
				oPrice.get().getEnd_date());
	}
}