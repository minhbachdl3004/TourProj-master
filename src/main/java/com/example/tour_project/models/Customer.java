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
@Table(name = "customer")
@RequiredArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "makhachhang", unique = true, nullable = false, length = 45)
    private String makhachhang;

    @Column(name = "hoten", length = 45)
    private String hoten;

    @Column(name = "cmnd", length = 45)
    private String cmnd;

    @Column(name = "diachi", length = 45)
    private String diachi;

    @Column(name = "gioitinh", length = 45)
    private String gioitinh;

    @Column(name = "sdt", length = 45)
    private String sdt;

    @Column(name = "quoctich", length = 45)
    private String quoctich;
}
