package com.example.VaccinationApplication.Repository;


import com.example.VaccinationApplication.Model.Doctor;
import com.example.VaccinationApplication.Model.Dose;
import com.example.VaccinationApplication.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    Doctor findByEmailId(String emailId);
}
