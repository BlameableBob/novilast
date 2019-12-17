package comloiane.springcloudmysql.controller;

import comloiane.springcloudmysql.model.Contact;
import comloiane.springcloudmysql.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;



@Controller
public class VolunteerController {
    @Autowired
    private ContactRepository repository;

    public List<Contact> findAll(){
        return repository.findAll();
    }

    @RequestMapping(value = "/volunteers", method = RequestMethod.GET)
    public String contacts(Model model) {
        //test
/*        Contact c = new Contact();
        c.setName("Jack Bauer");
        c.setBirthDate("1-1-2010");
        c.setCity("Afghanistan");
        List<Contact> contacts = new ArrayList<>();
        contacts.add(c);
        model.addAttribute("contacts", contacts);*/
        model.addAttribute("contacts", findAll());
        return "/volunteers.html";
    }

    @RequestMapping("/volunteer/new")
    public String newVoluneer(Model model){
        model.addAttribute("contact", new Contact());
        return "/registerpage.html";
    }

    @RequestMapping(value = "/volunteer", method = RequestMethod.POST)
    public String saveVoluneer(Contact contact){
        repository.save(contact);
        //return "redirect:/product/show/" + product.getId();
        return "redirect:/confirmationpage";
    }

    @RequestMapping(value = "/confirmationpage", method = RequestMethod.GET)
    public String confirmVolunteer(){
        return "/confirmationpage";
    }


}
