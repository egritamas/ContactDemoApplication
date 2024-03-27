package hu.demo.contacts.repository;

import hu.demo.contacts.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    public List<Address> findByCid(Long id);

    public void deleteByCid(Long id);
}
