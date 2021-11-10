package com.puentedigital.multiposting.dto.payloads.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserChangePasswordDTO {

    @Size(min = 8)
    private String oldPassword;

    @Size(min = 8)
    private String password;
}
