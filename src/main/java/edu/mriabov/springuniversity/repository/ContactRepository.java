
package edu.mriabov.springuniversity.repository;

import edu.mriabov.springuniversity.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Integer>{

//    List<Contact> findByStatus(String status);

    Page<Contact> findByStatus(String status, Pageable pageable);

}