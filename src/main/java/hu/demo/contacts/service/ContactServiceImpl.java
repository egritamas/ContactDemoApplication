package hu.demo.contacts.service;

import hu.demo.contacts.dto.ContactDto;
import hu.demo.contacts.entity.Contact;
import hu.demo.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public void addContact(ContactDto contact) {
        contactRepository.save(convertToEntity.apply(contact));
    }

    @Override
    public List<Contact> fetchContacts() {
        return (List<Contact>) contactRepository.findAll();
    }

    @Override
    public ContactDto getContact(Long id) {
        return convertToDto.apply(contactRepository.getReferenceById(id));
    }

    @Override
    public void saveContact(ContactDto contact) {
        contactRepository.save(convertToEntity.apply(contact));
    }

    @Override
    public void anonymize(Long id){
        String randomId =  String.valueOf(new Random().nextInt(10000,20000));
        Contact contact = contactRepository.getReferenceById(id);
        contact.setName("Anonym" + randomId);
        contact.setEmail("anonym." + randomId + "@contact.demo.hu");
        contact.setMothers_name("Mother of " + randomId);
        contact.setSocial_number("00" + randomId);
        contact.setStatus("I");

        contactRepository.save(contact);
    }


}
