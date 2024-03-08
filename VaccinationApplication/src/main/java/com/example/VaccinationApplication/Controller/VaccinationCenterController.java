package com.example.VaccinationApplication.Controller;

import com.example.VaccinationApplication.Model.VaccinationCenter;
import com.example.VaccinationApplication.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccinationCenter")

public class VaccinationCenterController {
    @Autowired
    VaccinationCenterService vaccinationCenterService;
    @PostMapping("/add-center")
    public String addCenter(@RequestBody VaccinationCenter center){
        return vaccinationCenterService.addVaccinationCenter(center);
    }
    @GetMapping("/all-doctors")
    public ResponseEntity<List<String>> getAllDoctors(@RequestParam Integer centerId){
        try{
            List<String> doctorList = vaccinationCenterService.getAllDoctors(centerId);
            return new ResponseEntity<>(doctorList, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/all-male-doctors")
    public ResponseEntity<List<String>> getAllMaleDoctors(@RequestParam Integer centerId){
        try{
            List<String> doctorList = vaccinationCenterService.getAllMaleDoctors(centerId);
            return new ResponseEntity<>(doctorList, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/all-female-doctors")
    public ResponseEntity<List<String>> getAllFemaleDoctors(@RequestParam Integer centerId){
        try{
            List<String> doctorList = vaccinationCenterService.getAllFemaleDoctors(centerId);
            return new ResponseEntity<>(doctorList, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/all-male-doctors-above-40")
    public ResponseEntity<List<String>> getAllMaleDoctorsAbove40(@RequestParam Integer centerId){
        try{
            List<String> doctorList = vaccinationCenterService.getAllMaleDoctorsAbove40(centerId);
            return new ResponseEntity<>(doctorList, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
