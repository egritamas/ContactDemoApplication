package hu.demo.contacts.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDto
{
    private Long id;
    private String phone;
    private String type;
    private Long contact_id;
}
