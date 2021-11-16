package com.example.tour_project.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "place")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Place implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "madiadiem")
    private String madiadiem;

    @Column(name = "tendiadiem")
    private String tendiadiem;

    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY)
    private List<PlaceOrder> placeOrders;
}
