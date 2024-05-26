package com.prosigmaka.backendjobapplication.entity.biodata;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.prosigmaka.backendjobapplication.model.pendidikan.PendidikanResponseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pendidikan")
public class PendidikanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "biodata_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private BiodataEntity biodataId;
    @Column(name = "jenjang_pendidikan", nullable = false)
    private String jenjangPendidikan;
    @Column(name = "nama_institusi", nullable = false)
    private String namaInstitusi;
    @Column(name = "jurusan", nullable = false)
    private String jurusan;
    @Column(name = "tahun_lulus", nullable = false)
    private Year tahunLulus;
    @Column(name = "ipk", nullable = false)
    private Double ipk;

    public PendidikanResponseModel entityToDto(){
        PendidikanResponseModel pendidikan = new PendidikanResponseModel();
        pendidikan.setNama(biodataId.getNama());
        pendidikan.setJenjangPendidikan(jenjangPendidikan);
        pendidikan.setNamaInstitusi(namaInstitusi);
        pendidikan.setJurusan(jurusan);
        pendidikan.setTahunLulus(tahunLulus);
        pendidikan.setIpk(ipk);
        return pendidikan;
    }
}
