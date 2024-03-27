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
    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public List<Address> fetchAddresses() {
        return (List<Address>) addressRepository.findAll();
    }

    @Override
    public Address getAddress(Long id) {
        return addressRepository.getReferenceById(id);
    }

    @Override
    public List<AddressDto> getAddressesByContactId(Long id) {
        return
                addressRepository.findByCid(id).stream().
                        map(convertToDto).collect(Collectors.toList());
    }
}
