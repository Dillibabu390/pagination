package com.application.myapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;

@Data
@ToString
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class FormRequest {

    @NotNull(message = "username shouldn't be null")
    private String name;

    @NotBlank
    private String address;

    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
    private String phoneNumber;

    @Min(18)
    @Max(60)
    private String age;


   /* @Email(message = "invalid email address")
    private String email;

    @Min(18)
    @Max(60)
    private int age;*/


}
