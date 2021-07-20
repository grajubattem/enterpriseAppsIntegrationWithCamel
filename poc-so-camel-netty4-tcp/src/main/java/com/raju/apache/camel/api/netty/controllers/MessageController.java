package com.raju.apache.camel.api.netty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.raju.apache.camel.api.netty.dto.MessageRequest;
import com.raju.apache.camel.api.netty.dto.MessageResponse;
import com.raju.apache.camel.api.netty.services.MessageService;

@RestController
public class MessageController {

  private MessageService messageService;

  @Autowired
  public MessageController(final MessageService messageService) {
    this.messageService = messageService;
  }

  @PostMapping(path = "/sendMessage")
  public ResponseEntity<?> sendMessage(@RequestBody final MessageRequest msgRequest) {
    if (msgRequest.getMessage() == null || msgRequest.getMessage().isEmpty()) {
      return ResponseEntity.badRequest().build();
    }
    
    this.messageService.sendToTCP(msgRequest.getMessage());
    return ResponseEntity.accepted().build();
  }

  @GetMapping(path = "/messages")
  public ResponseEntity<MessageResponse> getReceivedMessages() {
    final MessageResponse response = new MessageResponse();
    response.setMessages(this.messageService.getReceivedMessages());
    return ResponseEntity.ok(response);
  }
}
