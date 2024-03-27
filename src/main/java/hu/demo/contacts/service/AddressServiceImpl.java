package hu.demo.contacts.service;

import hu.demo.contacts.dto.AddressDto;
import hu.demo.contacts.entity.Address;
import hu.demo.contacts.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public void saveAddress(AddressDto address) {
        addressRepository.save(convertToEntity.apply(address));
    }

    @Override
    public List<AddressDto> fetchAddresses() {
        return (List<AddressDto>) addressRepository.findAll().stream().map(convertToDto).collect(Collectors.toList());
    }

    @Override
    public AddressDto getAddress(Long id) {
        return convertToDto.apply(addressRepository.getReferenceById(id));
    }

    @Override
    public List<AddressDto> getAddressesByContactId(Long id) {
        return
                addressRepository.findByCid(id).stream().
                        map(convertToDto).collect(Collectors.toList());
    }
}
