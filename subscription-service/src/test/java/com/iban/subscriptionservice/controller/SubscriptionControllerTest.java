package com.iban.subscriptionservice.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.iban.subscriptionservice.model.Subscription;
import com.iban.subscriptionservice.service.SubscriptionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(value = SubscriptionController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class SubscriptionControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SubscriptionService service;


    @Test
    public void whenPostSubscription_thenCreateSubscription() throws Exception {
        Subscription s = new Subscription();
        String json = "\n" +
                "{'firstName':'Ramon Rios',\n" +
                "'email':'ramon.rios@gmail.com',\n" +
                "'consent':true,\n" +
                "'dateOfBirth':'06/07/1993',\n" +
                "'newsletterID':'123'}" ;
        s.setFirstName("Ramon Rios");
        s.setConsent(true);
        s.setDateOfBirth("06/07/1993");
        s.setEmail("email@email.com");
        s.setNewsletterId("1");
        given(service.save(Mockito.any())).willReturn(s);
        mvc.perform(post("/subscription").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated());
        verify(service, VerificationModeFactory.times(1)).save(Mockito.any());
        reset(service);
    }



}
