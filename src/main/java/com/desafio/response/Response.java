package com.desafio.response;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> {
	
	private T data;
}
