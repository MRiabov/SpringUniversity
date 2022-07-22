package edu.mriabov.springuniversity.service;

import edu.mriabov.springuniversity.model.ContactInquiry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactInquiryService {
    private final Logger log = LoggerFactory.getLogger(ContactInquiryService.class);

    public boolean saveMessageDetails(ContactInquiry contactInquiry){
        boolean isSaved=true;
        //todo save info into the DB
        log.info(contactInquiry.toString());
        return isSaved;
    }
}
