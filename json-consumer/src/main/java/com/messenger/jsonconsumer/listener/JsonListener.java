package com.messenger.jsonconsumer.listener;

import com.messenger.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "fraud-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment){
        log.info("Payment received {}", payment.toString());
        sleep(2000);
        log.info("Validating fraud...");
        sleep(2000);
        log.info("Purchase approved...");
        sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment){
        sleep(3000);
        log.info("Generating pdf of product id {}...", payment.getIdProduct());
        sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(){
        sleep(3000);
        log.info("Sending confirmation email...");
    }

}
