package com.proje.mergenTech.entity;

import lombok.Data;

import java.util.Date;


@Data
public class Filtre {
    private String hastaneAdi;
    private String kullaniciKodu;
    private Date ilkTarih;
    private Date sonTarih;
}
