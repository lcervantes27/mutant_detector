package com.lgcm.mutantDetector.exceptions;
/**
 * @author lgerardocv@gmail.com
 * Class for administration of exceptions
 */
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GestionExceptions {
	/*
	 * Create a exception with custom message
	 * */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> manejaError(Exception e){
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("detail", e.getMessage());
        return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
}
