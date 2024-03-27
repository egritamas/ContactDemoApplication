package hu.demo.contacts.controller;

import hu.demo.contacts.dto.AddressDto;
import hu.demo.contacts.dto.ContactDto;
import hu.demo.contacts.dto.PhoneDto;
import hu.demo.contacts.service.AddressService;
import hu.demo.contacts.service.ContactService;
import hu.demo.contacts.service.PhoneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.stream.Stream;

@Controller
public class ContactController {

    @Autowired private ContactService contactService;

    @Autowired private PhoneService phoneService;

    @Autowired private AddressService addressService;

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
    public String createContact(@RequestBody @Valid ContactDto contact, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("newcontact", contact);
            return "redirect:newcontact";
        }
        contactService.addContact(contact);
        return "redirect:/";
    }

    @GetMapping("/contact/{id}")
    public String contactDetails(@PathVariable Long id, Model model){
        ContactDto contact =  contactService.getContact(id);
        contact.setPhones(phoneService.getPhonesByContactId(contact.getId()));
        contact.setAddresses(addressService.getAddressesByContactId(contact.getId()));
        model.addAttribute("contact", contact);

        PhoneDto phone = new PhoneDto();
        phone.setContact_id(id);
        model.addAttribute("phoneDto", phone);

        AddressDto address = new AddressDto();
        address.setContact_id(id);
        model.addAttribute("addressDto", address);

        return "contactdetails";
    }

    @PostMapping("/saveContact")
    public String saveContact(@RequestBody @Valid ContactDto contact, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("contact", contact);
            PhoneDto phone = new PhoneDto();
            phone.setContact_id(contact.getId());
            model.addAttribute("phoneDto", phone);

            AddressDto address = new AddressDto();
            address.setContact_id(contact.getId());
            model.addAttribute("addressDto", address);

            return "redirect:contactdetails";
        }

        contactService.saveContact(contact);
        if(!CollectionUtils.isEmpty(contact.getPhones())) {
            contact.getPhones().forEach(p -> phoneService.savePhone(p));
        }
        if(!CollectionUtils.isEmpty(contact.getAddresses())) {
            contact.getAddresses().forEach(a -> addressService.saveAddress(a));
        }
        return "redirect:/";
    }

    @GetMapping("/deleteContact/{id}")
    public   String deleteContact(@PathVariable Long id, Model model){
        contactService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/addPhone")
    public   String addPhone(Model model, @ModelAttribute PhoneDto phone){
        phoneService.savePhone(phone);
        return "redirect:/contact/" + phone.getContact_id();
    }

    @PostMapping("/addAddress")
    public   String addPhone(Model model, @ModelAttribute AddressDto address){
        addressService.saveAddress(address);
        return "redirect:/contact/" + address.getContact_id();
    }

    @GetMapping("/anonymizeContact/{id}")
    public String anonymize(@PathVariable Long id, Model model){
        contactService.anonymize(id);
        return "redirect:/";
    }

}
