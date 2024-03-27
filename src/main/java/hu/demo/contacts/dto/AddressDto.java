package hu.demo.contacts.dto;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;
    private String zip_code;
    private String city;
    private String street;
    private String house_number;
    private Long contact_id;
}
