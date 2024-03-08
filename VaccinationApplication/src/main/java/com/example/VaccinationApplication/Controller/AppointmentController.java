package com.example.VaccinationApplication.Controller;

import com.example.VaccinationApplication.Dtos.AddAppointmentDto;
import com.example.VaccinationApplication.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    @PostMapping("add-appointment")
    public ResponseEntity<String> addAppointment(@RequestBody AddAppointmentDto addAppointmentDto){
        try{
            String response = appointmentService.addAppointment(addAppointmentDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}
