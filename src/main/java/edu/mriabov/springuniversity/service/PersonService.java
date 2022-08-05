package edu.mriabov.springuniversity.service;

import edu.mriabov.springuniversity.constants.RolesConstants;
import edu.mriabov.springuniversity.model.Person;
import edu.mriabov.springuniversity.model.Roles;
import edu.mriabov.springuniversity.repository.AddressRepository;
import edu.mriabov.springuniversity.repository.PersonRepository;
import edu.mriabov.springuniversity.repository.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
@RequiredArgsConstructor
public class PersonService {

    private PersonRepository personRepository;
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person) {
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(RolesConstants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (person!=null && person.getPersonId()>0) isSaved = true;
        return isSaved;
    }

}
