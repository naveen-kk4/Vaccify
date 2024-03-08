package com.example.VaccinationApplication.Dtos.GetDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class ConnectDocCenter {
    private int docId;
    private int centerId;
}
