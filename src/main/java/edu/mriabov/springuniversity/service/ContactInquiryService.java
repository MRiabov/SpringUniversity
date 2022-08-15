package edu.mriabov.springuniversity.service;

import edu.mriabov.springuniversity.constants.ContactInquiryConstants;
import edu.mriabov.springuniversity.model.Contact;
import edu.mriabov.springuniversity.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContactInquiryService {

    private final ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved=false;
        contact.setStatus(ContactInquiryConstants.OPEN);
        Contact savedContact=contactRepository.save(contact);
        if (savedContact.getContactId()>0) isSaved=true;
        return isSaved;
    }

    public boolean updateMsgStatus(int contactID) {
        int rows=contactRepository.updateStatusById(ContactInquiryConstants.CLOSED,contactID);
        //if updated rows>0 operation is successful
        return rows > 0;
    }

    public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir) {
        int pageSize=5;
        Pageable pageable = PageRequest.of(pageNum, pageSize,
                (sortDir.equals("asc")) ?
                (Sort.by(sortField).ascending()) : (Sort.by(sortField).descending()));

        return contactRepository.findByStatusWithQuery(ContactInquiryConstants.OPEN,pageable);
    }
}