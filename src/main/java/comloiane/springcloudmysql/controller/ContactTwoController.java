package comloiane.springcloudmysql.controller;

import comloiane.springcloudmysql.model.Contact;
import comloiane.springcloudmysql.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactTwoController {
    @Autowired
    private ContactRepository repository;

    public List<Contact> findAll(){
        return repository.findAll();
    }

    @GetMapping(path = "/volunteers")
    public String contacts(Model model) {
        //test
        /*Contact c = new Contact();
        c.setName("Jack Bauer");
        c.setBirthDate("1-1-2010");
        c.setCity("Afghanistan");
        List<Contact> contacts = new ArrayList<>();
        contacts.add(c);*/
        //model.addAttribute("contacts", contacts);
        model.addAttribute("contacts", findAll());
        return "/table.html";
    }
}
