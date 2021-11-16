package com.example.tour_project.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@Entity
@Table(name = "staff_allocation")
public class StaffAllocation implements Serializable {
    @Id
    @Column(name = "manhanvien", unique = true, nullable = false, length = 45)
    private String manhanvien;

    @Id
    @Column(name = "madoan", unique = true, nullable = false, length = 45)
    private String madoan;

    @Column(name = "nhiemvu")
    private String nhiemvu;
}
