package com.acme.messaging.controller.dto;

import lombok.Data;

/**
 * Represents the payload for POST /api/v1/messages.
 */
@Data
public class MessagePayload {

  private String message;
}
