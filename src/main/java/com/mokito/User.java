package com.mokito;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean isAktive;


    public User(String name, boolean isAktive) {
        this.name = name;
        this.isAktive =isAktive;
    }
}
