package com.example.tour_project.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tour_price")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TourPrice implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "magia")
    private String magia;

    @Column(name = "matour")
    private String matour;

    @Column(name = "thanhtien")
    private float thanhtien;

    @Column(name = "thoigianbatdau")
    @Temporal(TemporalType.DATE)
    private Date dateStart;

    @Column(name = "thoigianketthuc")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;

    @ManyToOne
    @JoinColumn(name = "matour", nullable = false, insertable = false, updatable = false)
    private Tour tour;

//    @ManyToOne
//    @JoinColumn(name = "matour", nullable = false, insertable = false, updatable = false)
//    private TouristGroup touristGroup;

}
