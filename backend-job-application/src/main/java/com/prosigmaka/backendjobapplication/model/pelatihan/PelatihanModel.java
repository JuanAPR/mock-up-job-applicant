package com.prosigmaka.backendjobapplication.model.pelatihan;

import com.prosigmaka.backendjobapplication.entity.biodata.PelatihanEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PelatihanModel {
    private String namaKursus;
    private String sertifikat;
    private Year tahun;

    public PelatihanEntity dtoToEntity(){
        PelatihanEntity pelatihan = new PelatihanEntity();
        pelatihan.setNamaKursus(namaKursus);
        pelatihan.setSertifikat(sertifikat);
        pelatihan.setTahun(tahun);
        return pelatihan;
    }
}
