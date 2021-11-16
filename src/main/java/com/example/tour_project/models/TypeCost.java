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
@Table(name = "type_cost")
@RequiredArgsConstructor
public class TypeCost {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "maloaichiphi", unique = true, nullable = false, length = 45)
    private String maloaichiphi;

    @Column(name = "tenchiphi")
    private String tenchiphi;
}
