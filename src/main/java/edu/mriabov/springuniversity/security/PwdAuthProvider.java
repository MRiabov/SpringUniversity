package edu.mriabov.springuniversity.security;

import edu.mriabov.springuniversity.model.Person;
import edu.mriabov.springuniversity.model.Roles;
import edu.mriabov.springuniversity.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PwdAuthProvider implements AuthenticationProvider {

    private final PersonRepository personRepository;

    @Autowired
    public PwdAuthProvider(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String email = auth.getName();
        String pwd = auth.getCredentials().toString();
        Person person = personRepository.readByEmail(email);
        if (person != null && person.getPersonId() > 0 && pwd.equals(person.getPwd())) {
            return new UsernamePasswordAuthenticationToken(person.getName(), pwd,
                    getGrantedAuthorities(person.getRoles()));
        } else throw new BadCredentialsException("Invalid credentials!");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private List<GrantedAuthority> getGrantedAuthorities(Roles roles){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+roles.getRoleName()));
        return grantedAuthorities;
    }
}
