package hu.demo.contacts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="contact_id_seq")
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "birth_date", nullable = true)
    private Date birth_date;

    @Column(name = "mothers_name", nullable = true)
    private String mothers_name;

    @Column(name = "social_number", nullable = true)
    private String social_number;

    @Column(name = "tax_number", nullable = true)
    private String tax_number;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "status", nullable = true)
    private String status;

}
