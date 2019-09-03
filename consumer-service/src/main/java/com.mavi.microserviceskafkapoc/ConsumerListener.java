package com.mavi.microserviceskafkapoc;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor( onConstructor = @__( @Autowired ) )
public class ConsumerListener {
  
  static final String TOPIC = "random";
  private final MessageRepository messageRepository;
  
  @KafkaListener( topics = TOPIC,
                  groupId = "sampleGroup" )
  public String getMessage ( String message ) {
    messageRepository.save(message, TOPIC);
    log.info("[Consuming message]: {}, with date: {}", message, LocalDateTime.now());
    return message;
  }
}
