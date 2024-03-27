package hu.demo.contacts.controller;

import hu.demo.contacts.dto.ContactDto;
import hu.demo.contacts.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class ContactController {

    @Autowired private ContactService contactService;

    @GetMapping("/")
    public String viewHomePage(Model model)
    {
        model.addAttribute("contacts",  contactService.fetchContacts());
        return "index";

    }


    @GetMapping("/addnew")
    public String addNewContact(Model model) {
        ContactDto contact = new ContactDto();
        model.addAttribute("newcontact", contact);
        return "newcontact";
    }

    @PostMapping("/addcontact")
    public String createContact(@Valid ContactDto contact, Model model){

        contactService.addContact(contact);
        return "redirect:/";
    }

    @GetMapping("/contact/{id}")
    public String contactDetails(@PathVariable Long id, Model model){
        model.addAttribute("contact", contactService.getContact(id));
        return "contactdetails";
    }

    @PostMapping("/saveContact")
    public String saveContact(@Valid ContactDto contact, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "contactdetails";
        }
        contactService.saveContact(contact);
        return "redirect:/";
    }

    @GetMapping("/deleteContact/{id}")
    public   String deleteContact(@PathVariable Long id, Model model){
        contactService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/contact/{id}/anonymize")
    public String anonymize(@PathVariable Long id, Model model){
        contactService.anonymize(id);
        return "redirect:/";
    }

}
