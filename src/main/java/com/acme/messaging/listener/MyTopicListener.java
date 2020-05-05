package com.acme.messaging.listener;

import com.acme.messaging.avro.MyObject;
import com.acme.messaging.sink.MyTopicSink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Class that contains the listener for my-topic.
 */
@Slf4j
@Component
public class MyTopicListener {

  /**
   * Consumes messages from my-topic.
   *
   * @param consumedMessage the consumed message
   */
  @StreamListener(MyTopicSink.INPUT)
  public void consume(Message<MyObject> consumedMessage) {
    log.info("Consumed object: {}", consumedMessage.getPayload());

    // manually acknowledging the message
    Acknowledgment acknowledgment = consumedMessage.getHeaders()
        .get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
    if (acknowledgment != null) {
      acknowledgment.acknowledge();
    }
  }
}
