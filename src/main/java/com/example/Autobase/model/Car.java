package com.example.Autobase.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "carrying", nullable = false)
    private float carrying;

    @Column(name = "is_free", nullable = false)
    private boolean isFree = true;

    @Column(name = "is_broke", nullable = false)
    private boolean isBroke = false;

    @Column(name = "time_to_repair", nullable = false)
    private int timeToRepair = 0;

    public boolean getBroke()
    {
        return isBroke;
    }
}
