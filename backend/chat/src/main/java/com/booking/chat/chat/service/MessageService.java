package com.booking.chat.chat.service;


import com.booking.chat.chat.domain.Message;
import com.booking.chat.chat.repository.MessageRepository;
import com.booking.chat.kafka.domain.KafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public void save(KafkaMessage message, Long chatroomId) {

        Message saveMessage = Message.builder()
                                     .chatroomId(chatroomId)
                                     .memberId(message.getSenderId()) // sender가 member_id라고 가정
                                     .content(message.getMessage())
                                     .build();

        messageRepository.save(saveMessage).subscribe();
    }

    public Flux<Message> findAllByRoomId(Long roomId) {

        return messageRepository.findByChatRoomId(roomId);
    }
}
