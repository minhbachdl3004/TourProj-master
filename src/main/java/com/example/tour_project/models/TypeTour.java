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
@Table(name = "type_tour")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TypeTour implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "maloaihinh")
    private String maloaihinh;

    @Column(name = "tenloaihinh")
    private String tenloaihinh;

    @OneToMany(mappedBy = "loaihinh", fetch = FetchType.LAZY)
    private List<Tour> tours;
}
