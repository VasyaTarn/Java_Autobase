package com.example.Autobase.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateDTO {
    private int idCity;
    private int idCargoType;
    private float weight;
}
