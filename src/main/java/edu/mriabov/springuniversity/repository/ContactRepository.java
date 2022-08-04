
package edu.mriabov.springuniversity.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import edu.mriabov.springuniversity.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Integer>{

}