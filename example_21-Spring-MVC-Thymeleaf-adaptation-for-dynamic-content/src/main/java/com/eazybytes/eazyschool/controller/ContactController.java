package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage() {
        return "contact.html";
    }

    /*
     * @RequestParam:
     * Purpose: Extracts individual parameters from the URL query string or form data (submitted via GET or POST methods) and maps
     * them to method parameters.
     * How it works: It is typically used to capture data sent as part of a form or query string (e.g., key-value pairs in the URL).
     * The form inputs (like name, mobileNum, email, etc.) are passed to the controller using @RequestParam.
     * Form Data: The form sends a POST request with the form inputs (name, mobileNum, etc.), and these values are mapped to the
     * corresponding method parameters using @RequestParam.
     * Where it works: Typically used in form submissions (application/x-www-form-urlencoded) or URL query parameters
     * (?param1=value1&param2=value2).
     * */

//    @PostMapping("/saveMsg")
//    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
//                                    @RequestParam String email, @RequestParam String subject, @RequestParam String message) {
//        log.info("Name : " + name);
//        log.info("Mobile Number : " + mobileNum);
//        log.info("Email Address : " + email);
//        log.info("Subject : " + subject);
//        log.info("Message : " + message);
//        return new ModelAndView("redirect:/contact");
//    }

    @PostMapping("/saveMsg")
    public ModelAndView saveMessage(Contact contact) {
        contactService.saveMessageDetails(contact);

        /*
         * When the controller method returns new ModelAndView("redirect:/contact"), Spring tells the browser to make a new request
         * to /contact by issuing a 302 Redirect.
         * The client (browser) will then follow the redirect and load the /contact page.
         * */
        return new ModelAndView("redirect:/contact");
    }


}
