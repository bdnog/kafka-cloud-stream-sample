package com.acme.messaging.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Represents the producer.
 */
public interface MyTopicSource {

  String OUTPUT = "my-topic-source";

  /**
   * @return the message channel
   */
  @Output(OUTPUT)
  MessageChannel output();
}
