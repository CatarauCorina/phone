package controller;

/**
 * Created by cataraucorina on 23/08/2017.
 */
import org.springframework.web.bind.annotation.*;
import service.DataFetcher;
import model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cataraucorina on 23/08/2017.
 */
@CrossOrigin(origins = "http://localhost:8090/")
@RestController
@EnableWebMvc
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private DataFetcher dataFetcher;


    @RequestMapping(value = "/", method = RequestMethod.GET,produces = "application/JSON")
    @ResponseBody
    public ResponseEntity<List<Contact>> getAll() {
        List<Contact> contacts;
        try {

            contacts= this.dataFetcher.getContacts();
        } catch (Exception e) {
            return new ResponseEntity<List<Contact>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/{field}",method = RequestMethod.GET,produces = "application/JSON")
    @ResponseBody
    public ResponseEntity<List<Contact>> searchContact(@PathVariable String field ){
        try {
            List<Contact> filteredContacts=new ArrayList<>();
            List<Contact> contacts= this.dataFetcher.getContacts();
            contacts.stream().forEach(contact -> {
                if (contact.getName().toLowerCase().contains(field) || contact.getAddress().toLowerCase().contains(field)){
                    filteredContacts.add(contact);
                }
            });
            return new ResponseEntity<>(filteredContacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

