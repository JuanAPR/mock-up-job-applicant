package com.prosigmaka.backendjobapplication.entity.biodata;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.prosigmaka.backendjobapplication.model.pelatihan.PelatihanResponseModel;
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
@Table(name = "pelatihan")
public class PelatihanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "biodata_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private BiodataEntity biodata;
    @Column(name = "nama_kursus")
    private String namaKursus;
    @Column(name = "sertifikat")
    private String sertifikat;
    @Column(name = "tahun")
    private Year tahun;

    public PelatihanResponseModel entityToDto(){
        PelatihanResponseModel pelatihan = new PelatihanResponseModel();
        pelatihan.setNama(biodata.getNama());
        pelatihan.setNamaKursus(namaKursus);
        pelatihan.setSertifikat(sertifikat);
        pelatihan.setTahun(tahun);
        return pelatihan;
    }
}
