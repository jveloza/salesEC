package com.sales.app.service;

import com.sales.app.request.PriceRequest;
import com.sales.app.response.PriceResponse;

public interface IPriceService{
	
	PriceResponse findByBrandProductDate(PriceRequest priceRequest);
	
}
