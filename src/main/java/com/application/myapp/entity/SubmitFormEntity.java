package com.application.myapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "form")
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@ToString
@Data
public class SubmitFormEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    private String phoneNumber;

    private String age;

}
