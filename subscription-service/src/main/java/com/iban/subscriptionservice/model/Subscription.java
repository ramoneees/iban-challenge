package com.iban.subscriptionservice.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NonNull;

@Entity
@Table
@Data
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false )
    private String email;

    @Column
    private String firstName;

    @Column(nullable = false)
    @NonNull
    private String dateOfBirth;

    @Column
    private boolean consent;

    @Column
    private String newsletterId;

    public Subscription() {

    }
}
