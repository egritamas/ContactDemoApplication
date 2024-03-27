package hu.demo.contacts.service;

import hu.demo.contacts.dto.AddressDto;
import hu.demo.contacts.entity.Address;

import java.util.List;
import java.util.function.Function;

public interface AddressService {

    Function<Address, AddressDto> convertToDto = a ->
            AddressDto.builder()
                    .city(a.getCity())
                    .street(a.getStreet())
                    .house_number(a.getHouse_number())
                    .zip_code(a.getZip_code())
                    .contact_id(a.getCid())
                    .build();

    Function <AddressDto, Address> convertToEntity = a ->
            Address.builder()
                    .zip_code(a.getZip_code())
                    .city(a.getCity())
                    .house_number(a.getHouse_number())
                    .street(a.getStreet())
                    .cid(a.getContact_id())
                    .build();

    public List<AddressDto> getAddressesByContactId(Long id);

    public List<Address> fetchAddresses();

    public void addAddress(Address Address);

    public Address getAddress(Long id);

}
