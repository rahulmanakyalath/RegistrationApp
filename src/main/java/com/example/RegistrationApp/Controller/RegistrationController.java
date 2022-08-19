package com.example.RegistrationApp.Controller;

import com.example.RegistrationApp.Entity.UserDetailsTbl;
import com.example.RegistrationApp.Services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/regisApp")
public class RegistrationController {

    @Autowired
    UserRegistrationService userRegistrationService;

    @PostMapping("/details")
    public ResponseEntity<String>saveUserDetails(@RequestBody  UserDetailsTbl userDto){

        String str = "same user exists";

       if(userRegistrationService.userRegistration(userDto)!=null){
           str = "success";
       }
        return ResponseEntity.ok(str);
    }
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDetailsTbl>>getAllUsers(){
        List<UserDetailsTbl> list = new LinkedList<UserDetailsTbl>();
        list = userRegistrationService.allUsers();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getUser")
    public ResponseEntity<String>getUser(@RequestBody  UserDetailsTbl userDto)
    {
        String validate = "User not present with emailId "+ userDto.getEmailId() + " And Password "+userDto.getPassword();
        if(userRegistrationService.getUser(userDto)==1){
            validate = "Found a User with emailId "+ userDto.getEmailId() + " And Password "+userDto.getPassword();
        }
        return ResponseEntity.ok(validate);
    }
    @DeleteMapping("/deleteUser/{email}")
    public ResponseEntity<String>getUser(@PathVariable  String email){
        String value = "User not found with email id = "+email;
        if(userRegistrationService.delUser(email)==1){
            value = "User Deleted with email id = "+email;
        }
        return ResponseEntity.ok(value);
    }



}
