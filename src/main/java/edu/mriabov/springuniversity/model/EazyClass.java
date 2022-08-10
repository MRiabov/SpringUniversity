package edu.mriabov.springuniversity.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "class")
public class EazyClass extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int classId;

    @NotBlank(message = "Name of the class must not be blank.")
    @Size(min=2, message = "Size must not be less than 2.")
    private String name;

    @OneToMany(mappedBy = "eazyClass",fetch = FetchType.LAZY,
    cascade = CascadeType.PERSIST, targetEntity = Person.class)
    private Set<Person> persons;


}
