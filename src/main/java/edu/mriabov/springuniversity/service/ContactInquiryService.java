package edu.mriabov.springuniversity.service;

import edu.mriabov.springuniversity.constants.ContactInquiryConstants;
import edu.mriabov.springuniversity.model.Contact;
import edu.mriabov.springuniversity.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ContactInquiryService {
    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved=false;
        contact.setStatus(ContactInquiryConstants.OPEN);
        contact.setCreatedBy(ContactInquiryConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        Contact savedContact=contactRepository.save(contact);
        if (null!= savedContact&&savedContact.contactId>0) isSaved=true;
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        return contactRepository.findByStatus(ContactInquiryConstants.OPEN);
    }

    public boolean updateMsgStatus(int contactID, String updatedBy) {
        boolean isUpdated=false;
        Optional<Contact> contact = contactRepository.findById(contactID);
        contact.ifPresent(contact1->{
            contact1.setStatus(ContactInquiryConstants.CLOSED);
            contact1.setUpdatedBy(updatedBy);
            contact1.setUpdatedAt(LocalDateTime.now());
        });
        Contact updatedContact=contactRepository.save(contact.get());
        if (updatedContact.getUpdatedBy()!=null) isUpdated=true;
        return isUpdated;
    }
}