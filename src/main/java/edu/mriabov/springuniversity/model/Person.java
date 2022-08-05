package edu.mriabov.springuniversity.model;


import edu.mriabov.springuniversity.annotation.FieldsValueMatch;
import edu.mriabov.springuniversity.annotation.PasswordValidator;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "pwd",
                fieldMatch = "confirmPwd",
                message = "Passwords do not match!"
        ),
        @FieldsValueMatch(
                field = "email",
                fieldMatch = "confirmEmail",
                message = "Emails do not match!"
        )
})
public class Person {

    @Id
    @Size(min = 2, message = "Name should be at least 2 characters long.")
    @NotNull(message = "Name must not be blank.")
    private String name;

    @NotNull(message = "Email must not be blank.")
    @Email
    private String email;

    @NotNull(message = "Mobile number must not be blank.")
    private String mobileNumber;

    @NotNull(message = "Please confirm your email.")
    @Transient
    private String confirmEmail;

    @NotNull(message = "Password must not be blank.")
    @PasswordValidator
    @Size(min = 6, message = "Password should be at least 6 characters long.")
    private String pwd;

    @NotNull(message = "Please confirm your password.")
    @Transient
    private String confirmPwd;
}
