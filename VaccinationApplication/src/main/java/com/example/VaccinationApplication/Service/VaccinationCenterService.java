package com.example.VaccinationApplication.Service;


import com.example.VaccinationApplication.Enum.Gender;
import com.example.VaccinationApplication.Exceptions.CenterNotFoundException;
import com.example.VaccinationApplication.Exceptions.VaccinationAddressEmptyException;
import com.example.VaccinationApplication.Model.Doctor;
import com.example.VaccinationApplication.Model.VaccinationCenter;
import com.example.VaccinationApplication.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.example.VaccinationApplication.Enum.Gender.MALE;


@Service

public class VaccinationCenterService {
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    public String addVaccinationCenter(VaccinationCenter center) {
        if(Objects.isNull(center.getAddress()))throw new VaccinationAddressEmptyException("address not found ");
        vaccinationCenterRepository.save(center);
        return "new Center created successfully";
    }

    public List<String> getAllDoctors(Integer centerId) throws CenterNotFoundException {
        Optional<VaccinationCenter> centerOptional = vaccinationCenterRepository.findById(centerId);
        if(centerOptional.isEmpty()) throw new CenterNotFoundException("center not found");

        VaccinationCenter center = centerOptional.get();
        List<Doctor> doctorList = center.getDoctorList();
        List<String> ans = new ArrayList<>();
        for(Doctor doc : doctorList)ans.add(doc.getName());
        return ans;
    }

    public List<String> getAllMaleDoctors(Integer centerId) throws CenterNotFoundException {
        Optional<VaccinationCenter> centerOptional = vaccinationCenterRepository.findById(centerId);
        if(centerOptional.isEmpty()) throw new CenterNotFoundException("center not found");

        VaccinationCenter center = centerOptional.get();
        List<Doctor> doctorList = center.getDoctorList();
        List<String> ans = new ArrayList<>();
        for(Doctor doc : doctorList){
            if(doc.getGender()== Gender.MALE)ans.add(doc.getName());

        }
        return ans;
    }

    public List<String> getAllFemaleDoctors(Integer centerId) {
        Optional<VaccinationCenter> centerOptional = vaccinationCenterRepository.findById(centerId);
        if(centerOptional.isEmpty()) throw new CenterNotFoundException("center not found");

        VaccinationCenter center = centerOptional.get();
        List<Doctor> doctorList = center.getDoctorList();
        List<String> ans = new ArrayList<>();
        for(Doctor doc : doctorList){
            if(doc.getGender()== Gender.FEMALE)ans.add(doc.getName());

        }
        return ans;
    }

    public List<String> getAllMaleDoctorsAbove40(Integer centerId) {
        Optional<VaccinationCenter> centerOptional = vaccinationCenterRepository.findById(centerId);
        if(centerOptional.isEmpty()) throw new CenterNotFoundException("center not found");

        VaccinationCenter center = centerOptional.get();
        List<Doctor> doctorList = center.getDoctorList();
        List<String> ans = new ArrayList<>();
        for(Doctor doc : doctorList){
            if(doc.getGender()== MALE && doc.getAge() > 40)ans.add(doc.getName());

        }
        return ans;
    }
}
