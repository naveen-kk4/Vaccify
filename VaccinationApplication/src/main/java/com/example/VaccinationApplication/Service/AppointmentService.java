package com.example.VaccinationApplication.Service;

import com.example.VaccinationApplication.Dtos.AddAppointmentDto;
import com.example.VaccinationApplication.Exceptions.DoctorNotFoundException;
import com.example.VaccinationApplication.Exceptions.UserNotFoundException;
import com.example.VaccinationApplication.Model.Appointment;
import com.example.VaccinationApplication.Model.Doctor;
import com.example.VaccinationApplication.Model.Users;
import com.example.VaccinationApplication.Repository.AppointmentRepository;
import com.example.VaccinationApplication.Repository.DoctorRepository;
import com.example.VaccinationApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    DoctorRepository doctorRepository;



    public String addAppointment(AddAppointmentDto addAppointmentDto) throws DoctorNotFoundException,UserNotFoundException{
       Optional<Doctor> doctorOptional =  doctorRepository.findById(addAppointmentDto.getDocId());
        if(!doctorOptional.isPresent())throw new DoctorNotFoundException("doctor is not present");
        Optional<Users> userOptional = userRepository.findById(addAppointmentDto.getUserId());

        if(!userOptional.isPresent())throw new UserNotFoundException("user is not present");
        Doctor doc = doctorOptional.get();
        Users user = userOptional.get();
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(addAppointmentDto.getAppointmentDate());
        appointment.setAppointmentTime(addAppointmentDto.getAppointmentTime());
        appointment.setUser(user);
        appointment.setDoctor(doc);
        appointment=appointmentRepository.save(appointment);
        doc.getAppointmentList().add(appointment);
        user.getAppointmentList().add(appointment);
        doctorRepository.save(doc);
        userRepository.save(user);
        return "appointment booked successfully";

    }
}
