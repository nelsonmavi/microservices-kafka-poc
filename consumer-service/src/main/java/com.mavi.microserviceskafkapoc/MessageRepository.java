package com.mavi.microserviceskafkapoc;

import java.util.List;

public interface MessageRepository {
  
  List<String> findAll ( String messageTopic );
  
  void save ( String message, String messageTopic );
}
