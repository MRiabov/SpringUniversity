package edu.mriabov.springuniversity.service;

import edu.mriabov.springuniversity.model.ContactInquiry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactInquiryService {

    public boolean saveMessageDetails(ContactInquiry contactInquiry){
        boolean isSaved=true;
        //todo save info into the DB
        log.info(contactInquiry.toString());
        return isSaved;
    }
}