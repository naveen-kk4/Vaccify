package com.example.VaccinationApplication.Controller;

import com.example.VaccinationApplication.Dtos.GetDto.ConnectDocCenter;
import com.example.VaccinationApplication.Model.Doctor;
import com.example.VaccinationApplication.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")

public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/add-doctor")
    public String addDoctor(@RequestBody Doctor doctor){
        try{
            String response = doctorService.addDoctor(doctor);
            return response;
        }
        catch(Exception e){
            return e.getMessage();
        }

    }
    @GetMapping("/get-doctors-with-appointments-over-10")
    public ResponseEntity<List<String>> getDoctorsWithOver10Appointments(){

            List<String> doctors = doctorService.getAllDoctorsWith10plusAppointments();
            return new ResponseEntity<>(doctors, HttpStatus.OK);

    }



    @GetMapping("/get-male-doctors-aged-above-40")
    public ResponseEntity<List<String>> getMaleDoctorsAgedAbove40(){

            List<String> doctors = doctorService.getMaleDoctorsAgedAbove40();
            return new ResponseEntity<>(doctors, HttpStatus.OK);

    }
    @GetMapping("/get-male-female-ratio")
    public ResponseEntity<String> getMaleFemale(){

        String ratio = doctorService.getMaleFemaleRatio();
        return new ResponseEntity<>(ratio, HttpStatus.OK);

    }
    @PutMapping("/connect-doctor-with-center")
    public ResponseEntity<String> addDocToCenter(@RequestBody ConnectDocCenter connectDocCenter){
        try{
            String response = doctorService.addDocToCenter(connectDocCenter);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
