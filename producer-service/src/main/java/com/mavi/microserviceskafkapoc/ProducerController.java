package com.mavi.microserviceskafkapoc;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/producer" )
@AllArgsConstructor( onConstructor = @__( @Autowired ) )
public class ProducerController {
  
  private final Producer producer;
  
  @GetMapping
  public ResponseEntity greeting () {
    return ResponseEntity.ok("Hello world. I'm a producer service");
  }
  
  @PostMapping( value = "/publish" )
  public ResponseEntity produceMessage ( @RequestParam( "message" ) String message ) {
    producer.sendMessage(message);
    return ResponseEntity.ok().build();
  }
}
