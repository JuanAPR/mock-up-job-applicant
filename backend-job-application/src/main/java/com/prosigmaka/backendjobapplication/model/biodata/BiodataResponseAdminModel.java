package com.prosigmaka.backendjobapplication.model.biodata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiodataResponseAdminModel {
    private String nama;
    private String tempatLahir;
    private Date tanggalLahir;
    private String posisi;
}
