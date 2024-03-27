package hu.demo.contacts.service;

import hu.demo.contacts.dto.PhoneDto;
import hu.demo.contacts.entity.Phone;

import java.util.List;
import java.util.function.Function;

public interface PhoneService {

    Function<Phone, PhoneDto> convertToDto = p ->
            PhoneDto.builder()
                    .phone(p.getPhone_number())
                    .type(p.getType())
                    .contact_id(p.getCid())
                    .build();

    Function <PhoneDto, Phone> convertToEntity = p ->
            Phone.builder()
                    .phone_number(p.getPhone())
                    .type(p.getType())
                    .cid(p.getContact_id())
                    .build();

    public List<PhoneDto> getPhonesByContactId(Long id);

    public List<PhoneDto> fetchPhones();

    public void addPhone(PhoneDto phone);

    public PhoneDto getPhone(Long id);

}
