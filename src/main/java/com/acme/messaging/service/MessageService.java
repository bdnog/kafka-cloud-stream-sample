package com.acme.messaging.service;

import com.acme.messaging.controller.dto.MessagePayload;

/**
 * Interface with the message related services.
 */
public interface MessageService {

  /**
   * Publishes a message.
   *
   * @param messagePayload the message to be published
   */
  void publish(MessagePayload messagePayload);
}
