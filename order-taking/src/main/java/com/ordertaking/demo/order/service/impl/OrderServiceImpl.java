package com.ordertaking.demo.order.service.impl;

import com.ordertaking.demo.order.model.Order;
import com.ordertaking.demo.order.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final static String TOPIC_NAME = "order";
    private KafkaTemplate<String, Long> kafkaTemplate;

    @Override
    public void takeOrder(Order order) {
        kafkaTemplate.send(TOPIC_NAME, 10L);
    }

}