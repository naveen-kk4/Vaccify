package com.example.VaccinationApplication.Service;

import com.example.VaccinationApplication.Dtos.GetDto.updateEmailDto;
import com.example.VaccinationApplication.Model.Dose;
import com.example.VaccinationApplication.Model.Users;
import com.example.VaccinationApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service

public class UserService {
    @Autowired
    UserRepository userRepository;
    public Users addUser(Users user) {
        userRepository.save(user);
        return user;
    }

    public Date getVaccinationDate(Integer userId) {
        Users user = userRepository.findById(userId).get();
        Dose dose = user.getDose();
        return dose.getVaccinationDate();
    }

    public String updateEmail(updateEmailDto updateEmail) {
        int userId = updateEmail.getId();
        Users user = userRepository.getById(userId);
        user.setEmailId(updateEmail.getEmailId());
        userRepository.save(user);
        return "the email id has been changed to "+user.getEmailId();
    }

    public Users getUserByEmail(String email) {
           return userRepository.getByEmailId(email);

    }
}
