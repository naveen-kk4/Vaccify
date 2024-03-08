package com.example.VaccinationApplication.Repository;

import com.example.VaccinationApplication.Model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {

}
