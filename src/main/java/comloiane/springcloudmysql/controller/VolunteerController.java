package comloiane.springcloudmysql.controller;

import comloiane.springcloudmysql.model.Contact;
import comloiane.springcloudmysql.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    //via onderstaande kan iedereen zich aanmelden als vrijwilliger
    @RequestMapping("/volunteer/new")
    public String newVolunteer(Model model){
        model.addAttribute("contact", new Contact());
        return "/registerpage.html";
    }

    // geeft ook de mogelijkheid om een vrijwilliger toe te voegen, maar dan door een bevoegde user.
    @RequestMapping("/addVolunteer")
    public String addVolunteer(Model model){
        model.addAttribute("contact", new Contact());
        return "/addVolunteer.html";
    }

    @GetMapping(path = {"/volunteers/{id}"})
    public ResponseEntity<Contact> findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    //poging tot deleten van een vrijwilliger
    @RequestMapping(value="/volunteers/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/volunteers";
    }

    // hier worden de gegevens van de vrijwilligers gepost en opgeslagen in de DB.
    @RequestMapping(value = "/volunteer", method = RequestMethod.POST)
    public String saveVolunteer(Contact contact){
        repository.save(contact);
        //return "redirect:/product/show/" + product.getId();
        return "redirect:/confirmationpage";
    }
    // hier ook, maar dan door een bevoegde user.
    @RequestMapping(value = "/manuallyAddVolunteer", method = RequestMethod.POST)
    public String addVolunteer(Contact contact){
        repository.save(contact);
        //return "redirect:/product/show/" + product.getId();
        return "redirect:/volunteers";
    }

    @RequestMapping(value = "/confirmationpage", method = RequestMethod.GET)
    public String confirmVolunteer(){
        return "/confirmationpage";
    }


}
