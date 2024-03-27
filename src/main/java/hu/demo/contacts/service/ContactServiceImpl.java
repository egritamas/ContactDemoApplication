package hu.demo.contacts.service;

import hu.demo.contacts.dto.ContactDto;
import hu.demo.contacts.entity.Contact;
import hu.demo.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<ContactDto> fetchContacts() {
        return contactRepository.findAll().stream().map(convertToDto).collect(Collectors.toList());
    }

    @Override
    public ContactDto getContact(Long id) {
        return convertToDto.apply(contactRepository.getReferenceById(id));
    }

    @Override
    public ContactDto saveContact(ContactDto contact) {
        Contact response = contactRepository.save(convertToEntity.apply(contact));
        if (response != null) {
            return convertToDto.apply(response);
        } else return null;
    }

    @Override
    public void anonymize(Long id) {
        String randomId = String.valueOf(new Random().nextInt(10000, 20000));
        Contact contact = contactRepository.getReferenceById(id);
        contact.setName("Anonym" + randomId);
        contact.setEmail("anonym." + randomId + "@contact.demo.hu");
        contact.setMothers_name("Mother of " + randomId);
        contact.setSocial_number("00" + randomId);
        contact.setStatus("I");

        contactRepository.save(contact);
    }


}
