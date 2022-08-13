package edu.mriabov.springuniversity.rest;

import edu.mriabov.springuniversity.constants.ContactInquiryConstants;
import edu.mriabov.springuniversity.model.Contact;
import edu.mriabov.springuniversity.model.Response;
import edu.mriabov.springuniversity.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactRestController {

    final ContactRepository contactRepository;

    @GetMapping("/getMessageByStatus")
    public List<Contact> getMessageByStatus(@RequestParam(name = "status") String status){
        return contactRepository.findByStatus(status);
    }

    @GetMapping("/getAllMsgsByStatus")
    public List<Contact> getAllMsgsByStatus(@RequestBody Contact contact){
        if (contact != null&&contact.getStatus()!=null){
            return contactRepository.findByStatus(ContactInquiryConstants.OPEN);
        } else return List.of();
    }

    @PostMapping("/saveMsg")
    public ResponseEntity<Response> saveMsg(@RequestHeader("invocationForm") String invocationForm,
                                            @Valid @RequestBody Contact contact){
        log.info(String.format("Header invocationForm = %s",invocationForm));
        contactRepository.save(contact);
        Response response = new Response();
        response.setStatusMsg("Message saved successfully");
        response.setStatusCode("200");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("isMsgStatus","true")
                .body(response);
    }

}
