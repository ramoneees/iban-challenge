package com.iban.subscriptionservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.iban.subscriptionservice.model.Subscription;


public interface SubscriptionRepository  extends JpaRepository<Subscription,Integer>{

    public Subscription findByFirstName (String firstName);

}
