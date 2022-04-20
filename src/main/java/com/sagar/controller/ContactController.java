package com.sagar.controller;

import com.sagar.entity.Contact;
import com.sagar.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping("/contact")
    public ResponseEntity<String> contact(@RequestBody Contact contact) {
        String status = service.upsert(contact);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/showcontacts")
    public ResponseEntity<List<Contact>> getALlContacts() {
        List<Contact> contacts = service.getAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable int id) {
        Contact contact = service.getContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deteleContact(@PathVariable int id) {
        String status = service.deleteContact(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
