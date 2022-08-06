package edu.mriabov.springuniversity.model;


import edu.mriabov.springuniversity.annotation.FieldsValueMatch;
import edu.mriabov.springuniversity.annotation.PasswordValidator;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
@Entity
public class Person extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int personId;

    @NotBlank(message="Name must not be blank")
    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    @NotBlank(message="Mobile number must not be blank")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotBlank(message="Email must not be blank")
    @Email(message = "Please provide a valid email address" )
    private String email;

    @NotBlank(message="Confirm Email must not be blank")
    @Email(message = "Please provide a valid confirm email address" )
    @Transient
    private String confirmEmail;

    @NotBlank(message = "Password must not be blank.")
    @PasswordValidator
    @Size(min = 6, message = "Password should be at least 6 characters long.")
    private String pwd;

    @NotBlank(message = "Please confirm your password.")
    @Transient
    private String confirmPwd;

    @OneToOne(fetch = FetchType.EAGER,cascade= CascadeType.PERSIST, targetEntity = Roles.class)
    @JoinColumn(name = "role_id",referencedColumnName = "roleId", nullable = false)
    private Roles roles;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, targetEntity = Address.class)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;
}