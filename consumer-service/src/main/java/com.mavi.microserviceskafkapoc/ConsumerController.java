package com.mavi.microserviceskafkapoc;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/consumer" )
@AllArgsConstructor( onConstructor = @__( @Autowired ) )
public class ConsumerController {
  
  private final MessageRepository messageRepository;
  
  @GetMapping
  public ResponseEntity greeting () {
    return ResponseEntity.ok("Hello world. I'm a consumer service");
  }
  
  @GetMapping( "/messages" )
  public ResponseEntity getMessages () {
    return ResponseEntity.ok(messageRepository.findAll(ConsumerListener.TOPIC));
  }
}
