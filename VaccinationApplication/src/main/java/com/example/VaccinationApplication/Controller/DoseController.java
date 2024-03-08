package com.example.VaccinationApplication.Controller;

import com.example.VaccinationApplication.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseService doseService;
    @PostMapping("/set-dose")
    public String setDose(@RequestParam Integer userId,@RequestParam Integer doseId){
        return doseService.setDose(userId,doseId);
    }
}
