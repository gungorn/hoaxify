package com.hoaxify.ws.error;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ApiError {
	private int status; // hata kodu
	private String message; // hata mesajı
	private String type; // hata mesajı
	private String path; // hatanın yaşandığı url
	private long timestamp = new Date().getTime(); // hata oluşma zamanı (sunucu saatine göre)

	private Map<String, String> errors; // request'te oluşan hatalar

	public ApiError(int status, String message, String type, String path) {
		this.status = status;
		this.message = message;
		this.type = type;
		this.path = path;

		this.errors = new HashMap<>();
	}

	public void putError(String key, String value) {
		this.errors.put(key, value);
	}
}
