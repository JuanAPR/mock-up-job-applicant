package com.prosigmaka.backendjobapplication.model.pendidikan;

import com.prosigmaka.backendjobapplication.entity.biodata.PendidikanEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PendidikanModel {
    private String jenjangPendidikan;
    private String namaInstitusi;
    private String jurusan;
    private Year tahunLulus;
    private Double ipk;

    public PendidikanEntity dtoToEntity(){
        PendidikanEntity pendidikan = new PendidikanEntity();
        pendidikan.setJenjangPendidikan(jenjangPendidikan);
        pendidikan.setNamaInstitusi(namaInstitusi);
        pendidikan.setJurusan(jurusan);
        pendidikan.setTahunLulus(tahunLulus);
        pendidikan.setIpk(ipk);
        return pendidikan;
    }
}
