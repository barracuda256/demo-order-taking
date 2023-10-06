package com.ordertaking.demo.order.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProcessingService {

    private final static String TOPIC_NAME = "order";

    @KafkaListener(topics = TOPIC_NAME)
    public void listenKafka(Long userId) {
        System.out.println("new userId = " + userId);
    }

}
