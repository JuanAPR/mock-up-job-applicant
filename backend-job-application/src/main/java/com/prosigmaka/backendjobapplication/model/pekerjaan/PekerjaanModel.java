package com.prosigmaka.backendjobapplication.model.pekerjaan;

import com.prosigmaka.backendjobapplication.entity.biodata.PekerjaanEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PekerjaanModel {
    private String perusahaan;
    private String posisiTerakhir;
    private Double pendapatanTerakhir;
    private Year tahunMulai;
    private Year tahunSelesai;

    public PekerjaanEntity dtoToEntity(){
        PekerjaanEntity pekerjaan = new PekerjaanEntity();
        pekerjaan.setPerusahaan(perusahaan);
        pekerjaan.setPosisiTerakhir(posisiTerakhir);
        pekerjaan.setPendapatanTerakhir(pendapatanTerakhir);
        pekerjaan.setTahunMulai(tahunMulai);
        pekerjaan.setTahunSelesai(tahunSelesai);
        return pekerjaan;
    }
}
