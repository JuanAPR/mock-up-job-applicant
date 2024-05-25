package com.prosigmaka.backendjobapplication.model.pelatihan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PelatihanResponseModel {
    private String nama;
    private String namaKursus;
    private String sertifikat;
    private Year tahun;
}
