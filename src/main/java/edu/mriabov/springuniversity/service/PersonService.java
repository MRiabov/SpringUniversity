package edu.mriabov.springuniversity.service;

import edu.mriabov.springuniversity.constants.RolesConstants;
import edu.mriabov.springuniversity.model.Person;
import edu.mriabov.springuniversity.model.Roles;
import edu.mriabov.springuniversity.repository.PersonRepository;
import edu.mriabov.springuniversity.repository.RolesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class PersonService {

    private final PasswordEncoder passwordEncoder;
    private final PersonRepository personRepository;
    private final RolesRepository rolesRepository;

    public boolean createNewPerson(Person person) {
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(RolesConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        if (person!=null && person.getPersonId()>0) isSaved = true;
        return isSaved;
    }

}
