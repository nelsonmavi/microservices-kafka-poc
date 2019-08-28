package com.mavi.microserviceskafkapoc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
  
  @GetMapping()
  public ResponseEntity<?> greeting () {
    return ResponseEntity.ok("Hello world. I'm a consumer service");
  }
}
