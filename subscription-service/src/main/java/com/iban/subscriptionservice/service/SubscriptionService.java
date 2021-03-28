package com.iban.subscriptionservice.service;


import java.util.ArrayList;
import java.util.List;

import com.iban.subscriptionservice.model.Subscription;
import com.iban.subscriptionservice.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<Subscription> getAllSubscriptions() {
        List<Subscription> subscriptions = new ArrayList<Subscription>();
        subscriptionRepository.findAll().forEach(Subscription -> subscriptions.add(Subscription));
        return subscriptions;
    }

    public Subscription getSubscriptionById(int id) {
        return subscriptionRepository.findById(id).get();
    }

    public Subscription getSubscriptionByFirstName(String firstName ) {
        return subscriptionRepository.findByFirstName(firstName);
    }

    public Subscription save(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public void delete(int id) {
        subscriptionRepository.deleteById(id);
    }
}
