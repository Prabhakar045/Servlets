package com.xwrokz.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "registration")
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String houseNumber;
    private String street;
    private String city;
    private String district;
    private String state;
    private String pincode;
    private String gender;
}
