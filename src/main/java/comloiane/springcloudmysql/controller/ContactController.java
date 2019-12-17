package comloiane.springcloudmysql.controller;


import comloiane.springcloudmysql.model.Contact;
import comloiane.springcloudmysql.repository.ContactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {

    private ContactRepository repository;

    ContactController(ContactRepository contactRepository)
    {

        this.repository = contactRepository;
    }

    // CRUD methods here
    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Contact> findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    // Hier pak ik de inhoud van de velden van de registerpage.html form, en voeg die toe als new contact in de DB. Daarna redirect de page de gebruiker naar de confirmationpage.html
    @PostMapping
    public Contact create(@RequestParam MultiValueMap body, HttpServletResponse httpServletResponse) throws IOException {
        Contact contact = new Contact();
        contact.setName(body.getFirst( "name").toString());
        contact.setBirthDate(body.getFirst("birthDate").toString());
        contact.setSex(body.getFirst("sex").toString());
        contact.setCity(body.getFirst("city").toString());
        contact.setAddress(body.getFirst("address").toString());
        contact.setPhone(body.getFirst("phone").toString());
        contact.setEmail(body.getFirst("email").toString());

        httpServletResponse.sendRedirect("http://localhost:8080/confirmationpage.html");

        return repository.save(contact);
    }


    /**
     @PutMapping(value="/{id}")
     public ResponseEntity<Contact> update(@PathVariable("id") long id,
     @RequestBody Contact contact){
     return repository.findById(id)
     .map(record -> {
     record.setName(contact.getName());
     record.setEmail(contact.getEmail());
     record.setPhone(contact.getPhone());
     Contact updated = repository.save(record);
     return ResponseEntity.ok().body(updated);
     }).orElse(ResponseEntity.notFound().build());
     }
     */
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}

