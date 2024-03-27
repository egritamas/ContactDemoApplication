package hu.demo.contacts.service;

import hu.demo.contacts.dto.PhoneDto;
import hu.demo.contacts.entity.Phone;

import java.util.List;
import java.util.function.Function;

public interface PhoneService {

    public static Function<Phone, PhoneDto> convertToDto = p ->
            PhoneDto.builder()
                    .id(p.getId())
                    .phone(p.getPhone_number())
                    .type(p.getType())
                    .contact_id(p.getCid())
                    .build();

    public static Function <PhoneDto, Phone> convertToEntity = p ->
            Phone.builder()
                    .id(p.getId())
                    .phone_number(p.getPhone())
                    .type(p.getType())
                    .cid(p.getContact_id())
                    .build();

    public List<PhoneDto> getPhonesByContactId(Long id);

    public List<PhoneDto> fetchPhones();

    public void savePhone(PhoneDto phone);

    public PhoneDto getPhone(Long id);

}
