package hu.demo.contacts.service;

import hu.demo.contacts.dto.AddressDto;
import hu.demo.contacts.entity.Address;

import java.util.List;
import java.util.function.Function;

public interface AddressService {

    Function<Address, AddressDto> convertToDto = a ->
            AddressDto.builder()
                    .id(a.getId())
                    .city(a.getCity())
                    .street(a.getStreet())
                    .house_number(a.getHouse_number())
                    .zip_code(a.getZip_code())
                    .contact_id(a.getCid())
                    .build();

    Function <AddressDto, Address> convertToEntity = a ->
            Address.builder()
                    .id(a.getId())
                    .zip_code(a.getZip_code())
                    .city(a.getCity())
                    .house_number(a.getHouse_number())
                    .street(a.getStreet())
                    .cid(a.getContact_id())
                    .build();

    public List<AddressDto> getAddressesByContactId(Long id);

    public List<AddressDto> fetchAddresses();

    public void saveAddress(AddressDto address);

    public AddressDto getAddress(Long id);

}
