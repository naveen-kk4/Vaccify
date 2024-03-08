package com.example.VaccinationApplication.Service;

import com.example.VaccinationApplication.Dtos.GetDto.ConnectDocCenter;
import com.example.VaccinationApplication.Enum.Gender;
import com.example.VaccinationApplication.Exceptions.CenterNotFoundException;
import com.example.VaccinationApplication.Exceptions.DoctorAlreadyExistsException;
import com.example.VaccinationApplication.Exceptions.DoctorNotFoundException;
import com.example.VaccinationApplication.Exceptions.EmailIdInvalidException;
import com.example.VaccinationApplication.Model.Doctor;
import com.example.VaccinationApplication.Model.VaccinationCenter;
import com.example.VaccinationApplication.Repository.DoctorRepository;
import com.example.VaccinationApplication.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    public String addDoctor(Doctor doctor) throws EmailIdInvalidException,DoctorAlreadyExistsException {
        if(Objects.isNull(doctor.getEmailId()) || doctor.getEmailId().equals(""))throw new EmailIdInvalidException("invalid Email Id");
        Doctor doc = doctorRepository.findByEmailId(doctor.getEmailId());
        if(!Objects.isNull(doc))throw new DoctorAlreadyExistsException("doctor already exists");
        doctorRepository.save(doctor);
        return "doctor added successfully";
    }

    public String addDocToCenter(ConnectDocCenter connectDocCenter) throws DoctorNotFoundException,CenterNotFoundException
    {
        Optional<Doctor> doctorOptional = doctorRepository.findById(connectDocCenter.getDocId());
        Optional<VaccinationCenter> vaccinationCenterOptional = vaccinationCenterRepository.findById(connectDocCenter.getCenterId());
        if(doctorOptional.isEmpty())throw new DoctorNotFoundException("doctor not present");
        if(vaccinationCenterOptional.isEmpty())throw new CenterNotFoundException("center is not present");
        Doctor doc = doctorOptional.get();
        VaccinationCenter center = vaccinationCenterOptional.get();
        doc.setVaccinationCenter(center);
        center.getDoctorList().add(doc);
       vaccinationCenterRepository.save(center);
       return "doctor has been successfully assigned to the Center";

    }

    public List<String> getAllDoctorsWith10plusAppointments() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<String> doctorList = new ArrayList<>();
        for(Doctor doc : doctors){
            if(doc.getAppointmentList().size()>10)doctorList.add(doc.getName());
        }
        return doctorList;
    }

    public List<String> getMaleDoctorsAgedAbove40() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<String> doctorList = new ArrayList<>();
        for(Doctor doc : doctors){
            if(doc.getAge()>40 && doc.getGender()== Gender.MALE)doctorList.add(doc.getName());
        }
        return doctorList;
    }

    public String getMaleFemaleRatio() {
        int male = 0;
        int female = 0;
        List<Doctor> doctors = doctorRepository.findAll();
        for(Doctor doc : doctors){
            if(doc.getGender()== Gender.MALE)male++;
            else female++;
        }
        int gcd = findGcd(male,female);
        return male/gcd + ":" + female/gcd;
        
    }

    private int findGcd(int a, int b) {
        if(a==0)return b;
        return findGcd(b%a,a);
    }


}
