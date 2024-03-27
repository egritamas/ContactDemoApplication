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
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="phone_id_seq")
    private Long id;
    @Column(name = "phone_number", nullable = true)
    private String phone_number;
    @Column(name = "type", nullable = true)
    private String type;
    @Column(name = "cid", nullable = true)
    private Long cid;
}

