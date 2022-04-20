package com.sagar.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT_DETAILS")
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private long phoneNumber;
    private String activeSwitch;

}
