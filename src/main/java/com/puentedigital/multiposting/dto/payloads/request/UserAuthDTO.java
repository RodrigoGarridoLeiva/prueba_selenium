package com.puentedigital.multiposting.dto.payloads.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthDTO {

    @NotBlank
    private String username;

    @Length(min = 8, max = 100)
    private String password;
}
