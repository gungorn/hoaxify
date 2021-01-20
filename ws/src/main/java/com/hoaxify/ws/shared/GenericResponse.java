package com.hoaxify.ws.shared;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //argumanları constructor üzerinden alabilmesini sağla
public class GenericResponse {
	private String message;
}
