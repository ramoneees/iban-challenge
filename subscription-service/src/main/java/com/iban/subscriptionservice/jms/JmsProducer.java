package com.iban.subscriptionservice.jms;

import com.iban.subscriptionservice.model.Subscription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JmsProducer {

    @Autowired
    JmsTemplate jmsTemplateTopic;

    @Value("${spring.activemq.topic}")
    private String topic;

    public void sendMessage(Subscription message){
        try{
            log.info("Attempting Send message to Topic: "+ topic);
            jmsTemplateTopic.convertAndSend(topic, message);
        } catch(Exception e){
            log.error("Recieved Exception during send Message: ", e);
        }
    }
}
