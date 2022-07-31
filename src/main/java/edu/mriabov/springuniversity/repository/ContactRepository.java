
package edu.mriabov.springuniversity.repository;

import edu.mriabov.springuniversity.model.ContactInquiry;
import edu.mriabov.springuniversity.rowmapper.ContactRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveContactInquiry(ContactInquiry contact){
        String sql="INSERT INTO CONTACT_MSG (NAME,MOBILE_NUM,EMAIL,SUBJECT,MESSAGE,STATUS," +
                "CREATED_AT,CREATED_BY) VALUES (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,contact.getName(),contact.getNumber(), contact.getEmail(),
                contact.getSubject(),contact.getMessage(),contact.getStatus(),contact.getCreatedAt(),
                contact.getCreatedBy());
    }

    public List<ContactInquiry> findMsgsWithStatus(String status) {
        String sql="SELECT * WHERE CONTACT_MSG WHERE STATUS = ?";
        return jdbcTemplate.query(sql,
                ps -> ps.setString(1, status),
                new ContactRowMapper());


    }
}