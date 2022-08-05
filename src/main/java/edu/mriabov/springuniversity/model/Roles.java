package edu.mriabov.springuniversity.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Roles extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int roleId;

    private String roleName;


}
