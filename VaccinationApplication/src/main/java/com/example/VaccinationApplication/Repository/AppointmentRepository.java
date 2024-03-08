package com.example.VaccinationApplication.Repository;

import com.example.VaccinationApplication.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
