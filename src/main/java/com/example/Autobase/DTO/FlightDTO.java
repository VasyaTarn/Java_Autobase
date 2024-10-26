package com.example.Autobase.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {
    private Integer flightId;
    private String cityName;
    private float destination;
    private String cargoName;
    private float weight;
    private String driverName;
    private String carName;
    private int countDayWay;
}
