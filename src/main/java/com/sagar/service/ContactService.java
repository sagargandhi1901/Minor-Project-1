package com.sagar.service;

import com.sagar.entity.Contact;

import java.util.List;

public interface ContactService {

    String upsert(Contact contact);

    List<Contact> getAllContacts();

    Contact getContactById(int cId);

    String deleteContact(int cId);
}
