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

    private final static String TOPIC_NEW_ORDER_NAME = "order";
    private final static String TOPIC_EMAIL_NEW_ORDER_NAME = "email_new_order";
    private KafkaTemplate<String, Order> kafkaTemplate;

    @Override
    public void takeOrder(Order order) {
        // TODO need to save into DB
        kafkaTemplate.send(TOPIC_NEW_ORDER_NAME, order);
        kafkaTemplate.send(TOPIC_EMAIL_NEW_ORDER_NAME, order);
    }

}
