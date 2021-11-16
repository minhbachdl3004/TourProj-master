package com.example.tour_project.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@Entity
@Table(name = "detail_tour_group")
public class DetailTourGroup {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "madoan", unique = true, nullable = false, length = 45)
    private String madoan;

    @Column(name = "hanhtrinh")
    private String hanhtrinh;

    @Column(name = "khachsan")
    private String khachsan;

    @Column(name = "diadiemthamquan")
    private String diadiemthamquan;

    @OneToOne
    @JoinColumn(name = "madoan", nullable = false, insertable = false, updatable = false)
    private TouristGroup touristGroup;
}
