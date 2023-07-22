package com.application.myapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "form")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class SubmitFormEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String address;

    private String phoneNumber;

    private String age;

}
