package com.ordertaking.demo.order.controller;

import com.ordertaking.demo.order.dto.Email;
import com.ordertaking.demo.order.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public void send(@RequestBody Email email){
        emailService.send(email);
    }

}
