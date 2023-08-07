package com.sales.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sales.app.request.PriceRequest;
import com.sales.app.response.ErrorMessageResponse;
import com.sales.app.service.IPriceService;

@RestController
@RequestMapping("/price")
public class PriceController {

	@Autowired
	private IPriceService ipriceservice;
	
	@GetMapping("/product")
	public ResponseEntity<?> findPriceProduct(@Valid @RequestBody PriceRequest price) throws MethodArgumentNotValidException
	{
		var response=ipriceservice.findByBrandProductDate(price);
		if(response == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessageResponse("Precio de producto no encontrado"));
		}
		return ResponseEntity.ok(response);
	}
}