package com.example.tour_project.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@Entity
@Table(name = "cost")
@RequiredArgsConstructor
public class Cost {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "machiphi", unique = true, nullable = false, length = 45)
    private String machiphi;

    @Column(name = "madoan")
    private String madoan;

    @Column(name = "sotien")
    private float sotien;
    private String maloaichiphi;
}
