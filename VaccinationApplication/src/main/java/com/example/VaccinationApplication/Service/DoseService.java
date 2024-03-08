package com.example.VaccinationApplication.Service;

import com.example.VaccinationApplication.Model.Dose;
import com.example.VaccinationApplication.Model.Users;
import com.example.VaccinationApplication.Repository.DoseRepository;
import com.example.VaccinationApplication.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;
    @Autowired
    UserRepository userRepository;
    public  String setDose(Integer userId, Integer doseId) {
        Users user = userRepository.findById(userId).get();
        Dose newDose = new Dose();
        newDose.setDoseId(doseId);
        newDose.setUser(user);
        user.setDose(newDose);
        userRepository.save(user);
        return "new dose added successfully";


    }
}
