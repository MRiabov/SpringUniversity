package edu.mriabov.springuniversity.service;

import edu.mriabov.springuniversity.constants.ContactInquiryConstants;
import edu.mriabov.springuniversity.model.ContactInquiry;
import edu.mriabov.springuniversity.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ContactInquiryService {
    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(ContactInquiry contact){
        boolean isSaved=false;
        contact.setStatus(ContactInquiryConstants.OPEN);
        contact.setCreatedBy(ContactInquiryConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result=contactRepository.saveContactInquiry(contact);
        if (result>0) isSaved=true;
        return isSaved;
    }

    public List<ContactInquiry> findMsgsWithOpenStatus(){
        return contactRepository.findMsgsWithStatus(ContactInquiryConstants.OPEN);
    }
}