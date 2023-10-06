package com.ordertaking.demo.order.service;

import com.ordertaking.demo.order.model.Order;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class EmailProcessingService {

    private final static String TOPIC_NAME = "email_new_order";

    private final EmailService emailService;

    @KafkaListener(topics = TOPIC_NAME)
    public void listenKafka(Order order) {
        log.info("order: {}", order);

        // TODO send email
    }

}
