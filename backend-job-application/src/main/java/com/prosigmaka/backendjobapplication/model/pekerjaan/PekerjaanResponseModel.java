package com.prosigmaka.backendjobapplication.model.pekerjaan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PekerjaanResponseModel {
    private String nama;
    private String perusahaan;
    private String posisiTerakhir;
    private Double pendapatanTerakhir;
    private Year tahunMulai;
    private Year tahunSelesai;
}
