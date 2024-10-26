package com.example.Autobase.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer orderId;
    private String cityName;
    private float destination;
    private String cargoName;
    private float cargoPrice;
    private float weight;
    private boolean isFlight;
}
