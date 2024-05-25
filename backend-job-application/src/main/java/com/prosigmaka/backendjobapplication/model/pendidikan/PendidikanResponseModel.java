package com.prosigmaka.backendjobapplication.model.pendidikan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PendidikanResponseModel {
    private String nama;
    private String jenjangPendidikan;
    private String namaInstitusi;
    private String jurusan;
    private Year tahunLulus;
    private Double ipk;
}
