package com.mavi.microserviceskafkapoc;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor( onConstructor = @__( @Autowired ) )
public class ProducerImpl implements Producer {
  
  static final String TOPIC = "random";
  private final KafkaTemplate<String, String> kafkaTemplate;
  
  @Override
  public void sendMessage ( String message ) {
    log.info("[Producing message]: {}, with date: {}", message, LocalDateTime.now());
    kafkaTemplate.send(TOPIC, message);
  }
}
