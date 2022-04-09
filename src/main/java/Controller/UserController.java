package Controller;

import Entity.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(path = "/allUsers", produces = {MediaType.APPLICATION_NDJSON_VALUE})
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }
    @GetMapping(path = "/users/{name}", produces = {MediaType.APPLICATION_NDJSON_VALUE})
    public List<String> findUserByName(){
        return userService.findUserByName();
    }
    @GetMapping(path = "/users/{vorname}", produces = {MediaType.APPLICATION_NDJSON_VALUE})
    public List<String> findUserByVorname(){
        return userService.findUserByVorname();
    }
    @GetMapping(path = "/allUsers/{age}", produces = {MediaType.APPLICATION_NDJSON_VALUE})
    public List<User> findAllUsersByAge(@PathVariable(value = "age")int age){
        return userService.findAllUsersByAgeMoreThanX(age);
    }
    @PostMapping("/save")
    public  User saveUser(User user){
        return userService.saveUser(user);
    }
}
