package com.iban.subscriptionservice.jms;

import com.iban.subscriptionservice.model.Subscription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
@Slf4j
public class JmsConsumer implements MessageListener {


    @Override
    @JmsListener(destination = "${spring.activemq.topic}")
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            Subscription s = (Subscription) objectMessage.getObject();
            //do additional processing
            log.info("Received Message: "+ s.toString());
        } catch(Exception e) {
            log.error("Received Exception : "+ e);
        }

    }
}