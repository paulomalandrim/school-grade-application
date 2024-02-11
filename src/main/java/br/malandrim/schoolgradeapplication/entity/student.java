package br.malandrim.schoolgradeapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class student {
    @Column private String name;
}
