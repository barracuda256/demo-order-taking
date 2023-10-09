package com.ordertaking.demo.order.service.impl;

import com.ordertaking.demo.order.dto.Email;
import com.ordertaking.demo.order.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Slf4j
//@AllArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

//    @Value("${email.sender}")
    private String sender = "demo.order256@gmail.com";

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender, SpringTemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void send(Email email) {
        final Context ctx = new Context();
        ctx.setVariable("order", email.order());
        var customer = email.order().customer();
        baseSendNewOrderHtmlMail(ctx, customer.email(), "new_order.html", "New Order #" + email.order().requestId());
    }

    private void baseSendNewOrderHtmlMail(Context ctx, String to, String templateName, String subject) {
        try {
            final String htmlContent = this.templateEngine.process(templateName, ctx);

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(htmlContent, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom(sender);
            javaMailSender.send(mimeMessage);
        }

        catch (Exception e) {
            throw new RuntimeException("Error while sending", e);
        }
    }

}
