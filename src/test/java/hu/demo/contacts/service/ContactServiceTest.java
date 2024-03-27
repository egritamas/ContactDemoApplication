package hu.demo.contacts.service;

import hu.demo.contacts.dto.ContactDto;
import hu.demo.contacts.entity.Contact;
import hu.demo.contacts.repository.ContactRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactServiceImpl contactService;

    @Test
    public void ContactService_CreateContact_ReturnContactDto(){

        ContactDto contactDto = ContactDto.builder()
                .name("Egri Tamas")
                .email("egri.tamas@demo.hu")
                .birth_date("1982-06-30")
                .mothers_name("Kovacs Viktoria")
                .social_number("123456789102")
                .tax_number("23443245563")
                .status("A")
                .build();

        Contact contact = ContactService.convertToEntity.apply(contactDto);

        Mockito.when(contactRepository.save(Mockito.any(Contact.class))).thenReturn(contact);

        ContactDto savedContact = contactService.saveContact(contactDto);

        Assertions.assertThat(savedContact).isNotNull();


    }

    @Test
    void ContactService_getAllContact_ReturnsContacts(){

        List<Contact> contacts = Mockito.mock(List.class);
        Mockito.when(contactRepository.findAll()).thenReturn(contacts);

        List<ContactDto> contactList = contactService.fetchContacts();

        Assertions.assertThat(contactList).isNotNull();
    }

    @Test
    public void ContactService_GetContactById_whenContactExists_ReturnContact(){

        Long contactId = 1L;

        Contact mockContact = Mockito.mock(Contact.class);

        Mockito.when(contactRepository.getReferenceById(contactId)).thenReturn(mockContact);

        ContactDto contactDto = contactService.getContact(contactId);

        Assertions.assertThat(contactDto).isNotNull();

    }

    @Test
    public void ContactService_getContactById_WhenContactNotExits_ReturnException(){

        Long contactId = 1L;

        Mockito.when(contactRepository.getReferenceById(contactId)).thenReturn(null);

        ContactDto contactDto = contactService.getContact(contactId);

        Assertions.assertThat(contactDto).isNull();

    }

}
