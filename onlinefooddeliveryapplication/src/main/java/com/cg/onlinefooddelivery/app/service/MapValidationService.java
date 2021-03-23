package com.cg.onlinefooddelivery.app.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface MapValidationService {

	ResponseEntity<?> mapValidationError(BindingResult result);
}
