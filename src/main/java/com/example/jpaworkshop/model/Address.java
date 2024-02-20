package com.example.jpaworkshop.model;

import jakarta.persistence.Embeddable;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Getter
@Setter
public class Address {
    private String country;
    private String city;
    private String street;
    private String zipCode;

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
