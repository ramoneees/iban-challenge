package com.iban.subscriptionservice.repository;
import java.util.List;
import com.iban.subscriptionservice.model.Subscription;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class SubscriptionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Test
    public void insertSubscription (){
        Subscription s = new Subscription();
        s.setFirstName("Ramon Rios");
        s.setConsent(true);
        s.setDateOfBirth("06/07/1993");
        s.setEmail("email@email.com");
        s.setNewsletterId("1");
        entityManager.persist(s);
        entityManager.flush();

        Subscription found = subscriptionRepository.findByFirstName("Ramon Rios");

        assertEquals(s.getFirstName(), found.getFirstName());
    }



}
