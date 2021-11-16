package com.example.tour_project.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@Entity
@Table(name = "staff")
@RequiredArgsConstructor
public class Staff implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "manhanvien", unique = true, nullable = false, length = 45)
    private String manhanvien;

    @Column(name = "tennhanvien", length = 45)
    private String tennhanvien;

    @Column(name = "sodienthoai", length = 45)
    private String sodienthoai;

    @Column(name = "diachi", length = 45)
    private String diachi;


    public Staff(String manhanvien, String tennhanvien, String sodienthoai, String diachi) {
        this.manhanvien = manhanvien;
        this.tennhanvien = tennhanvien;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
    }
}
