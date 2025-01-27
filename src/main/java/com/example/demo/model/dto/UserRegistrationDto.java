package com.example.demo.model.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
public class UserRegistrationDto {
    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    @Size(min = 5, max = 40)
    @Email
    private String email;
    @NotNull
    @Size(min = 5, max = 20)
    private String password;
    private String confirmPassword;

    public String getName () {
        return name;
    }

    public String getEmail () {
        return email;
    }

    public String getPassword () {
        return password;
    }

    public String getConfirmPassword () {
        return confirmPassword;
    }
}
