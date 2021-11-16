package com.example.tour_project.models;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tour")
@RequiredArgsConstructor
public class Tour implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "matour", unique = true, nullable = false, length = 15)
    private String matour;

    @Column(name = "tengoi", length = 45)
    private String tengoi;

    @Column(name = "maloaihinh", length = 45)
    private String maloaihinh;

    @Column(name = "dacdiem", length = 45)
    private String dacdiem;

    @ManyToOne
    @JoinColumn(name = "maloaihinh", nullable = false, insertable = false, updatable = false)
    private TypeTour loaihinh;

    @OneToMany(mappedBy = "tour")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TourPrice> prices;

    @OneToMany(mappedBy = "tour")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PlaceOrder> placeOrders;

    public Tour(String matour, TypeTour loaihinh, ArrayList<TourPrice> prices, ArrayList<PlaceOrder> placeOrders) {
        this.matour = matour;
        this.loaihinh = loaihinh;
        this.prices = prices;
        this.placeOrders = placeOrders;
    }
}
