package hu.demo.contacts.service;

import hu.demo.contacts.dto.PhoneDto;
import hu.demo.contacts.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {


    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public void addPhone(PhoneDto phoneDto) {
        phoneRepository.save(convertToEntity.apply(phoneDto));
    }

    @Override
    public List<PhoneDto> fetchPhones() {
        return phoneRepository.findAll().stream().map(convertToDto).collect(Collectors.toList());
    }

    @Override
    public PhoneDto getPhone(Long id) {
        return convertToDto.apply(phoneRepository.getReferenceById(id));
    }

    @Override
    public List<PhoneDto> getPhonesByContactId(Long id) {
        return
                phoneRepository.findByCid(id).stream().
                        map(convertToDto).collect(Collectors.toList());
    }
}
