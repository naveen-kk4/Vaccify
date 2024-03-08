package com.example.VaccinationApplication.Repository;

import com.example.VaccinationApplication.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<Users,Integer> {
    Users getByEmailId(String email);

}
