
package edu.mriabov.springuniversity.repository;

import edu.mriabov.springuniversity.model.Contact;
import edu.mriabov.springuniversity.rowmapper.ContactRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveContactInquiry(Contact contact){
        String sql="INSERT INTO CONTACT_MSG (NAME,MOBILE_NUM,EMAIL,SUBJECT,MESSAGE,STATUS," +
                "CREATED_AT,CREATED_BY) VALUES (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,contact.getName(),contact.getMobileNum(), contact.getEmail(),
                contact.getSubject(),contact.getMessage(),contact.getStatus(),contact.getCreatedAt(),
                contact.getCreatedBy());
    }

    public List<Contact> findMsgsWithStatus(String status) {
        String sql = "SELECT * FROM CONTACT_MSG WHERE STATUS = ?";
        return jdbcTemplate.query(sql, preparedStatement ->
                preparedStatement.setString(1, status),new ContactRowMapper());
    }

    public int updateMsgStatus(int contactID, String status, String updatedBy) {
        String sql="UPDATE CONTACT_MSG SET STATUS = ?, UPDATED_BY = ?, UPDATED_AT = ? WHERE CONTACT_ID = ?";
        return jdbcTemplate.update(sql, ps -> {
            ps.setString(1,status);
            ps.setString(2,updatedBy);
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            ps.setInt(4,contactID);
        });
    }
}