package com.sagar.service;

import com.sagar.entity.Contact;
import com.sagar.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Contact> foundById = contactRepository.findById(cId);
        if (foundById.isPresent()) {
            return foundById.get();
        }
        return null;
    }

    @Override
    public String deleteContact(int cId) {
        contactRepository.deleteById(cId);
        return "Contact deleted...";
    }
}
