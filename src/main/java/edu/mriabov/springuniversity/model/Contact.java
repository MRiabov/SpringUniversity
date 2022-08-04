package edu.mriabov.springuniversity.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
//todo noHashCode!
@Table(name= "contact_msg")
public class Contact extends BaseEntity{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="native")
    @GenericGenerator(name="native",strategy="native")
    @Column(name="contact_id")
    private int contactId;

    @NotBlank(message = "Name should not be blank.")
    @Size(min=3, message = "Name should be at least 3 letters long.")
    private String name;
    @NotBlank(message = "Mobile number should not be blank.")
    @Pattern(regexp = "(^$|\\d){10}")
    private String mobileNum;
    @NotBlank(message = "Email should not be blank.")
    @Email(message = "Please, enter a vaild email")
    private String email;
    @NotBlank(message = "Subject should not be blank.")
    @Size(min=5, message = "Subject should be at least 5 letter long")
    private String subject;
    @NotBlank(message = "Message should not be blank.")
    @Size(min=10, message = "Message should be at least 10 letters long")
    private String message;

    private String status;
}
