package com.room.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.exception.ApiException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.annotation.PostConstruct;

@Service
public class WhatsAppService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.whatsapp.from}")
    private String from;

    @PostConstruct
    public void init() {
        Twilio.init(accountSid, authToken);
    }

 /*   public void sendMessage(String to, String message) {
    	System.out.println("What sup message sending to:"+to);
    	Message msg =Message.creator(
                new PhoneNumber("whatsapp:" + to),
                new PhoneNumber(from),
                message
        ).create();        
        System.out.println("What sup message send succfully : "+msg.getSid());
    } */
    
    
    
    public void sendMessage(String to, String message) {
        try {
        	
        	System.out.println("WhatsApp sent to: " + to+" ,message::"+message);

            if (!to.startsWith("+")) {
                to = "+" + to;
            }

            Message msg = Message.creator(
                    new PhoneNumber("whatsapp:" + to),
                    new PhoneNumber(from),
                    message
            ).create();

            System.out.println("WhatsApp sent SID: " + msg.getSid());

        } catch (ApiException e) {

            if (e.getMessage().contains("50 daily messages limit")) {
                System.out.println("DAILY WHATSAPP LIMIT EXCEEDED – STOPPING SEND");
            } else {
                System.out.println("Twilio error: " + e.getMessage());
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
