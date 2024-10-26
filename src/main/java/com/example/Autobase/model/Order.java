package com.example.Autobase.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_city", referencedColumnName = "id", nullable = false)
    private City city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cargo", referencedColumnName = "id", nullable = false)
    private CargoType cargoType;

    @Column(name = "weight", nullable = false)
    private float weight;

    @Column(name = "is_flight", nullable = false)
    private boolean isFlight = false;

    public boolean getIsFlight() {
        return isFlight;
    }
}