package com.acme.messaging.service.impl;

import com.acme.messaging.avro.MyObject;
import com.acme.messaging.avro.MySubObject;
import com.acme.messaging.controller.dto.MessagePayload;
import com.acme.messaging.service.MessageService;
import com.acme.messaging.source.MyTopicSource;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Class with the message related services.
 */
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

  private final MyTopicSource myTopicSource;

  /**
   * Publishes a message.
   *
   * @param messagePayload the message to be published
   */
  @Override
  public void publish(MessagePayload messagePayload) {
    MyObject myObject = new MyObject(UUID.randomUUID().toString(),
        new MySubObject(messagePayload.getMessage()));
    myTopicSource.output().send(MessageBuilder.withPayload(myObject).build());
  }
}
