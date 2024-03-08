package com.example.VaccinationApplication.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddAppointmentDto {
    private int userId;
    private int  docId;
    private Date appointmentDate;

    private LocalTime appointmentTime;
}
