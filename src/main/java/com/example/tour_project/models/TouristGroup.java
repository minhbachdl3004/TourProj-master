package com.example.tour_project.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tourist_group")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TouristGroup implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "madoan")
    private String madoan;

    @Column(name = "matour")
    private String matour;

    @Column(name = "ngaykhoihanh")
    private Date ngaykhoihanh;

    @Column(name = "ngayketthuc")
    private Date ngayketthuc;

    @Column(name = "doanhthu")
    private float doanhthu;

    @OneToOne(mappedBy = "touristGroup")
    @LazyCollection(LazyCollectionOption.FALSE)
    private DetailTourGroup detailTourGroup;

//    @OneToMany(mappedBy = "touristGroup")
//    @LazyCollection(LazyCollectionOption.FALSE)
//    private List<TourPrice> tourPrice;

    @OneToMany(mappedBy = "touristGroup")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CustomerTour> customerTour;
}
