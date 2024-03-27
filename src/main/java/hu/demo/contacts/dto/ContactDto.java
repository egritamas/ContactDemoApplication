package hu.demo.contacts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {

    private Long id;
    @NotEmpty(message = "Contact's name cannot be empty.")
    @Size(min = 2, max = 50)
    private String name;
    @NotEmpty(message = "Mothers's name cannot be empty and more than 50 character.")
    @Size(min = 2, max = 50)
    private String mothers_name;
    private String birth_date;
    @NotEmpty(message = "Social number cannot be empty and more than 12 character.")
    @Size(min = 2, max = 12)
    private String social_number;
    @NotEmpty(message = "Tax number cannot be empty and more than 12 character.")
    private String tax_number;
    @Email(message = "Wrong e-mail")
    private String email;
    private String status;

    private List<AddressDto> addresses;
    private List<PhoneDto> phones;
}
