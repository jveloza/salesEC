package com.sales.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sales.app.request.PriceRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class SalesEcApplicationTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void GivenAProduct35455ABrand1ADay14AnHour10TheResultIsNotFound() throws Exception {
		PriceRequest request = new PriceRequest(1L,"2020-06-14 10:00:00",35455L);
		
		String requestbody = objectMapper.writeValueAsString(request);
		
		mvc.perform(get("/price/product").
				contentType(MediaType.APPLICATION_JSON).
				content(requestbody)).
		andExpect(status().isNotFound());
	}

	@Test
	void GivenAProduct35455ABrand1ADay14AnHour16TheResultIsNotFound() throws Exception {
		PriceRequest request = new PriceRequest(1L,"2020-06-14 16:00:00",35455L);
		
		String requestbody = objectMapper.writeValueAsString(request);
		
		mvc.perform(get("/price/product").
				contentType(MediaType.APPLICATION_JSON).
				content(requestbody)).
		andExpect(status().isNotFound());
	}
	
	@Test
	void GivenAProduct35455ABrand1ADay14AnHour21TheResultIsNotFound() throws Exception {
		PriceRequest request = new PriceRequest(1L,"2020-06-14 21:00:00",35455L);
		
		String requestbody = objectMapper.writeValueAsString(request);
		
		mvc.perform(get("/price/product").
				contentType(MediaType.APPLICATION_JSON).
				content(requestbody)).
		andExpect(status().isNotFound());
	}
	
	@Test
	void GivenAProduct35455ABrand1ADay15AnHour10TheResultIsNotFound() throws Exception {
		PriceRequest request = new PriceRequest(1L,"2020-06-15 10:00:00",35455L);
		
		String requestbody = objectMapper.writeValueAsString(request);
		
		mvc.perform(get("/price/product").
				contentType(MediaType.APPLICATION_JSON).
				content(requestbody)).
		andExpect(status().isNotFound());
	}
	
	@Test
	void GivenAProduct35455ABrand1ADay16AnHour21TheResultIsNotFound() throws Exception {
		PriceRequest request = new PriceRequest(1L,"2020-06-16 21:00:00",35455L);
		
		String requestbody = objectMapper.writeValueAsString(request);
		
		mvc.perform(get("/price/product").
				contentType(MediaType.APPLICATION_JSON).
				content(requestbody)).
		andExpect(status().isNotFound());
	}
	
	@Test
	void GivenAProduct35455ABrand1ADay14AnHour00TheResultIsOk() throws Exception {
		PriceRequest request = new PriceRequest(1L,"2020-06-14 00:00:00",35455L);

		String requestbody = objectMapper.writeValueAsString(request);

		mvc.perform(MockMvcRequestBuilders.get("/price/product").
				contentType(MediaType.APPLICATION_JSON).
				content(requestbody))
		.andExpect(status().isOk());
	}
	
	@Test
	void GivenAProduct35455ABrand1ADay15AnHour16TheResultIsConflict() throws Exception {
		PriceRequest request = new PriceRequest(1L,"2020-06-15 16:00:00",35455L);

		String requestbody = objectMapper.writeValueAsString(request);

		mvc.perform(MockMvcRequestBuilders.get("/price/product").
				contentType(MediaType.APPLICATION_JSON).
				content(requestbody))
		.andExpect(status().isConflict());
	}
}
