package com.example.VaccinationApplication.Controller;

import com.example.VaccinationApplication.Dtos.GetDto.updateEmailDto;
import com.example.VaccinationApplication.Model.Users;
import com.example.VaccinationApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")

public class UserController
{
    @Autowired
    UserService userService;
    @PostMapping("/add-user")
    public Users addUser(@RequestBody Users user){

        return userService.addUser(user);
    }
    @GetMapping("/getVaccination-date/{userId}")
    public Date getVaccinationDate(@PathVariable Integer userId){
        return userService.getVaccinationDate(userId);

    }
    @PutMapping("/updateEmail")
    public String updateEmail(@RequestBody updateEmailDto updateEmail){
        return userService.updateEmail(updateEmail);
    }
    @GetMapping("/get-user-by-email/{email}")
    public Users getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }
}
