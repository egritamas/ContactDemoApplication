package hu.demo.contacts.repository;

import hu.demo.contacts.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    public List<Phone> findByCid(@Param("cid") Long id);

    public void deleteByCid(Long id);

}
