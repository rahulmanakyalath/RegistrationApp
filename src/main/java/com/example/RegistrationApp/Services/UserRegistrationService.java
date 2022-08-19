package com.example.RegistrationApp.Services;

import com.example.RegistrationApp.Entity.UserDetailsTbl;
import com.example.RegistrationApp.Repositories.UserRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRegistrationService {

    @Autowired
    UserRegistrationRepo userRegistrationRepo;

    public UserDetailsTbl userRegistration(UserDetailsTbl userDto){

        UserDetailsTbl udt =null;
        if(userRegistrationRepo.IsExsistingUser(userDto.getName())==0) {
            userRegistrationRepo.save(userDto);
            udt=userDto;
        }
        return udt;
    }
    public List<UserDetailsTbl> allUsers(){
        return userRegistrationRepo.findAll();
        }

        public int getUser(UserDetailsTbl udt){
        int value = 0;
        if(userRegistrationRepo.findAllByEmailAndPass(udt.getEmailId(),udt.getPassword())>0)
        {
            value = 1;
        }
        return value;
        }

        public int delUser(String emailid){
        try {
            Optional<UserDetailsTbl> udt = Optional.ofNullable(userRegistrationRepo.findByEmailId(emailid));
            userRegistrationRepo.delete(udt.get());
        }
        catch(Exception e){
            return 0;
        }
        return 1;
        }

    }
