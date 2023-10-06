package com.ordertaking.demo.order.controller;

import com.ordertaking.demo.order.dto.OrderDto;
import com.ordertaking.demo.order.service.OrderService;
import com.ordertaking.demo.order.сonverter.OrderModelConverter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("${url.order.taking.root}")
public class OrderController {

    private static final String ORDER_PROCESSED = "Order processed";

    private OrderService orderService;
    private OrderModelConverter orderModelConverter;

    @PostMapping(value = "${url.order.taking.order}", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> takeOrder(@Valid @RequestBody OrderDto orderDto) {
        log.info("order: {}", orderDto);
        orderService.takeOrder(orderModelConverter.converter(orderDto));
        return ResponseEntity.ok(ORDER_PROCESSED);
    }

}
