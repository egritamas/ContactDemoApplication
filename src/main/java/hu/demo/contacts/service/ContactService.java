package hu.demo.contacts.service;

import hu.demo.contacts.dto.ContactDto;
import hu.demo.contacts.entity.Contact;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Function;


public interface ContactService {

    Function<Contact, ContactDto> convertToDto = c ->
            ContactDto.builder()
                    .id(c.getId())
                    .birth_date(new SimpleDateFormat("yyyy-MM-dd").format(c.getBirth_date()))
                    .name(c.getName())
                    .mothers_name(c.getMothers_name())
                    .social_number(c.getSocial_number())
                    .tax_number(c.getTax_number())
                    .email(c.getEmail())
                    .status(c.getStatus())
                    .build();

    Function <ContactDto, Contact> convertToEntity = c ->
            Contact.builder()
                    .id(c.getId())
                    .name(c.getName())
                    .mothers_name(c.getMothers_name())
                    .birth_date(Date.valueOf(c.getBirth_date()))
                    .social_number(c.getSocial_number())
                    .tax_number(c.getTax_number())
                    .email(c.getEmail())
                    .status(c.getStatus())
                    .build();

    public List<Contact> fetchContacts();

    public void addContact(ContactDto contact);

    public void saveContact(ContactDto contact);

    public Contact getContact(Long id);

    public void delete(Long id);

    public void anonymize(Long id);

}
