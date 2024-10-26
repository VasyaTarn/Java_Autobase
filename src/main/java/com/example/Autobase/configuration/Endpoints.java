package com.example.Autobase.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Endpoints {
    // all
    HOME("/"),
    LOGIN("/login"),
    REGISTRATION("/registration"),
    LOGOUT_SUCCESSFUL("/logoutSuccessful"),

    // auth users
    CREATE_ORDER("/create-order"),
    ORDERS("/orders"),
    FLIGHTS("/flights"),
    LOGOUT("/logout"),

    // admin
    CARGO_TYPES("/cargotypes"),
    CARS("/cars"),
    CITIES("/cities"),
    CREATE_CAR("/create-car"),
    CREATE_DRIVER("/create-driver"),
    DRIVERS("/drivers"),
    HISTORY("/histories");

    private final String endPoint;

    static public List<Endpoints> getEndpointForAllUsers()
    {
        List<Endpoints> endpoints = new ArrayList<>();

        endpoints.add(HOME);
        endpoints.add(LOGIN);
        endpoints.add(REGISTRATION);
        endpoints.add(LOGOUT_SUCCESSFUL);

        return endpoints;
    }

    static public List<Endpoints> getEndpointForAdminAndAuthUser()
    {
        List<Endpoints> endpoints = new ArrayList<>();

        endpoints.add(LOGOUT);
        endpoints.add(CREATE_ORDER);
        endpoints.add(ORDERS);
        endpoints.add(FLIGHTS);

        return endpoints;
    }

    static public List<Endpoints> getEndpointForAdmin()
    {
        List<Endpoints> endpoints = new ArrayList<>();

        endpoints.add(CARGO_TYPES);
        endpoints.add(CARS);
        endpoints.add(CITIES);
        endpoints.add(CREATE_CAR);
        endpoints.add(CREATE_DRIVER);
        endpoints.add(DRIVERS);
        endpoints.add(HISTORY);

        return endpoints;
    }
}
