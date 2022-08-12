package edu.mriabov.springuniversity.service;

import edu.mriabov.springuniversity.constants.ContactInquiryConstants;
import edu.mriabov.springuniversity.model.Contact;
import edu.mriabov.springuniversity.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ContactInquiryService {
    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved=false;
        contact.setStatus(ContactInquiryConstants.OPEN);
        Contact savedContact=contactRepository.save(contact);
        if (savedContact.getContactId()>0) isSaved=true;
        return isSaved;
    }

    public boolean updateMsgStatus(int contactID) {
        boolean isUpdated=false;
        Optional<Contact> contact = contactRepository.findById(contactID);
        contact.ifPresent(contact1-> contact1.setStatus(ContactInquiryConstants.CLOSED));
        Contact updatedContact=contactRepository.save(contact.get());
        if (updatedContact.getUpdatedBy()!=null) isUpdated=true;
        return isUpdated;
    }

    public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir) {
        int pageSize=5;
        Pageable pageable = PageRequest.of(pageNum, pageSize,
                (sortDir.equals("asc")) ?
                (Sort.by(sortField).ascending()) : (Sort.by(sortField).descending()));

        return contactRepository.findByStatus(ContactInquiryConstants.OPEN,pageable);
    }
}