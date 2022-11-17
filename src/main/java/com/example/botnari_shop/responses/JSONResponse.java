package com.example.botnari_shop.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JSONResponse{

	private ResponseStatus status;
	
	private Object data;
	
	
}