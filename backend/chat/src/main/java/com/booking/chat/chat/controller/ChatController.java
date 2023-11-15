package com.booking.chat.chat.controller;

import com.booking.chat.chat.domain.Message;
import com.booking.chat.chat.service.MessageService;
import com.booking.chat.kafka.domain.KafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RequiredArgsConstructor
@RestController("/api/chat")
public class ChatController {

    private final MessageService messageService;

    // 클라이언트에서 /publish/message 로 메시지를 전송
    @MessageMapping("/message/{chatroomId}")
    public void sendMessage(@Payload KafkaMessage kafkaMessage, @DestinationVariable("chatroomId") Long chatroomId) {
        log.info(" {} user request send message to {} chatroom", kafkaMessage.getSenderId(), chatroomId);

        messageService.processAndSend(kafkaMessage, chatroomId);
    }

    @GetMapping(value = "/{chatroomId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> findAllByRoomId(@PathVariable Long chatroomId) {

        return messageService.findAllByRoomId(chatroomId);
    }

    @PostMapping("/stress/{chatroomId}")
    public void stressTest(@PathVariable Long chatroomId, @RequestBody KafkaMessage kafkaMessage) {

        messageService.processAndSend(kafkaMessage, chatroomId);
    }

}