package hu.demo.contacts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "zip_code", nullable = true)
    String zip_code;
    @Column(name = "city", nullable = true)
    String city;
    @Column(name = "street", nullable = true)
    String street;
    @Column(name = "house_number", nullable = true)
    String house_number;
    @Column(name = "cid", nullable = true)
    Long cid;

}
