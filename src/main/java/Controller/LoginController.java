package Controller;

import Service.EmailRestRequest;
import Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")

public class LoginController {

    @Autowired
    LoginService loginService;
    @GetMapping(path = "testemail/{email}", produces = {MediaType.APPLICATION_NDJSON_VALUE})
    public String testEmail(@PathVariable(value = "email") String email){
        if( loginService.testEmail(email)){
            return "Email ist richtig";
        }
        else{
            return "Email ist falsch";
        }
    }
    @GetMapping(path = "testemail", produces = {MediaType.APPLICATION_NDJSON_VALUE})
    public EmailRestRequest testEmail(){
        return new EmailRestRequest("Blondelle@gmail.com");
    }

    @PostMapping(path = "testemail", produces = {MediaType.APPLICATION_NDJSON_VALUE})
    public String testEmail(@RequestBody EmailRestRequest emailRestRequest){
        if( loginService.testEmail(emailRestRequest.getEmail())){
            return "Email ist richtig";
        }
        else{
            return "Email ist falsch";
        }
    }
    @PutMapping (path = "testemail/Änderung/{newEmail}", produces = {MediaType.APPLICATION_NDJSON_VALUE})
    public String testEmail(@RequestBody EmailRestRequest emailRestRequest, @PathVariable(value = "newEmail") String email){
        if( loginService.testEmail(emailRestRequest.getEmail())){
            return "Email ist richtig";
        }
        else{
            return "Email ist falsch";
        }
    }
    @DeleteMapping (path = "testemail/{id}", produces = {MediaType.APPLICATION_NDJSON_VALUE})
    public String deleteEmail(@PathVariable(value = "id") String id){
        if( loginService.testEmail(id)){
            return "Email ist richtig";
        }
        else{
            return "Email ist falsch";
        }
    }
}
