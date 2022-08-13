
package edu.mriabov.springuniversity.repository;

import edu.mriabov.springuniversity.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Integer>{

    List<Contact> findByStatus(String status);

    @Query("SELECT c FROM Contact c WHERE c.status=:status")
    Page<Contact> findByStatus(String status, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Contact c set c.status = ?1 where c.contactId = ?2")
    int updateStatusById(String status, int id);

}