package com.sagar.service;

import com.sagar.entity.Contact;
import com.sagar.exception.UserNotFoundException;
import com.sagar.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public String upsert(Contact contact) {
        contactRepository.save(contact);
        return "Contact saved...";
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(int cId) {
        Contact contact = contactRepository.findById(cId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id : " + cId));
        return contact;
    }

    @Override
    public String deleteContact(int cId) {
        contactRepository.deleteById(cId);
        return "Contact deleted...";
    }
}
