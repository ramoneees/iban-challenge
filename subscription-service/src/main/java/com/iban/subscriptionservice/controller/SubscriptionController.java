package com.iban.subscriptionservice.controller;

import java.util.ArrayList;

import com.iban.subscriptionservice.model.Subscription;
import com.iban.subscriptionservice.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.net.URI;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.EntityModel;


@RestController
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @PostMapping("/subscription")
    public ResponseEntity<Object> createSubscription(@RequestBody Subscription subscription){

        Subscription savedSubscription = service.save(subscription);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedSubscription.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/subscription/{id}")
    public Subscription getSubscriptionById(@PathVariable("id") int subscriptionId){
        return service.getSubscriptionById(subscriptionId);
    }

}
