package com.example.rest_api.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stdId;
    private String stdName;
    private String stdEmail;
    private String stdPhone;
    private int stdAge;
    private String stdAddress;
    private String stdGrade;

}


