package com.acme.messaging.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Represents the consumer.
 */
public interface MyTopicSink {

  String INPUT = "my-topic-sink";

  /**
   * @return a subscribable channel
   */
  @Input(INPUT)
  SubscribableChannel channel();
}
