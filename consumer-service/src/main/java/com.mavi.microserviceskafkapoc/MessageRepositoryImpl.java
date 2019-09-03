package com.mavi.microserviceskafkapoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class MessageRepositoryImpl implements MessageRepository {
  
  private Map<String, List<String>> messagesStorage;
  
  @PostConstruct
  private void onInit () {
    messagesStorage = new HashMap<>();
  }
  
  @Override
  public List<String> findAll ( String messageTopic ) {
    return messagesStorage.get(messageTopic);
  }
  
  @Override
  public void save ( String message, String messageTopic ) {
    messagesStorage.computeIfAbsent(messageTopic, k -> new ArrayList<>()).add(message);
  }
}
