package edu.mriabov.springuniversity.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Profile {

    @Size(min=3, message="Name must be at least 3 characters long.")
    @NotBlank(message="Name must not be blank.")
    private String name;

    @NotBlank(message="Mobile number must not be blank.")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits.")
    private String mobileNumber;

    @NotBlank(message="Email must not be blank")
    @Email(message = "Please provide a valid email address" )
    private String email;

    @NotBlank
    @Size(min = 3, message = "Adress must not be blank.")
    private String address1;

    private String address2;

    @Size(min = 5, message = "City must be at least 3 characters long.")
    @NotBlank(message = "State must not be blank.")
    private String city;

    @NotBlank(message = "Zip code must not be blank.")
    @Pattern(regexp="(^$|[0-9]{5})", message = "Zip code must be 5 digits long")
    private String zipCode;

    @NotBlank(message = "State must not be blank.")
    @Size(min = 4, message = "State must be at least 4 characters long.")
    private String state;



}
