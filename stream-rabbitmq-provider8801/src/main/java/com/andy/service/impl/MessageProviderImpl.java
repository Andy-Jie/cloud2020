package com.andy.service.impl;

import com.andy.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(Source.class)
public class MessageProviderImpl implements MessageProvider {

    @Autowired
    private MessageChannel output;

    @Override
    public String send() {

        String message = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(message).build());

        return message;
    }
}
