package com.ordertaking.demo.order.service;

import com.ordertaking.demo.order.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProcessingService {

    private final static String TOPIC_NAME = "order";

    @KafkaListener(topics = TOPIC_NAME)
    public void listenKafka(Order order) {
        log.info("order: {}", order);

        // TODO send email
        // TODO change status in DB
    }

}
