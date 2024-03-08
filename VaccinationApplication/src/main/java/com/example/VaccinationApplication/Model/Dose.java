package com.example.VaccinationApplication.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="dose")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    private Users user;

    @Column(unique=true)
    private Integer doseId;

    @CreationTimestamp
    private Date vaccinationDate;


}
