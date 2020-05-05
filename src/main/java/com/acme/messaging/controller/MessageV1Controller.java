package com.acme.messaging.controller;

import com.acme.messaging.controller.dto.MessagePayload;
import com.acme.messaging.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for message related operations.
 */
@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageV1Controller {

  private final MessageService messageService;

  /**
   * Publishes a message.
   *
   * @param messagePayload the message to be published
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void post(@RequestBody MessagePayload messagePayload) {
    messageService.publish(messagePayload);
  }
}
