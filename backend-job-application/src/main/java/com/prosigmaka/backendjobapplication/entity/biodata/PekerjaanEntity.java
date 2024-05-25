package com.prosigmaka.backendjobapplication.entity.biodata;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.prosigmaka.backendjobapplication.model.pekerjaan.PekerjaanResponseModel;
import com.prosigmaka.backendjobapplication.model.pendidikan.PendidikanResponseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pekerjaan")
public class PekerjaanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "biodata_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private BiodataEntity biodataId;
    @Column(name = "perusahaan")
    private String perusahaan;
    @Column(name = "posisi_terakhir")
    private String posisiTerakhir;
    @Column(name = "pendapatan_terakhir")
    private Double pendapatanTerakhir;
    @Column(name = "tahun_mulai")
    private Year tahunMulai;
    @Column(name = "tahun_selesai")
    private Year tahunSelesai;

    public PekerjaanResponseModel entityToDto(){
        PekerjaanResponseModel pekerjaan = new PekerjaanResponseModel();
        pekerjaan.setNama(biodataId.getNama());
        pekerjaan.setPerusahaan(perusahaan);
        pekerjaan.setPosisiTerakhir(posisiTerakhir);
        pekerjaan.setPendapatanTerakhir(pendapatanTerakhir);
        pekerjaan.setTahunMulai(tahunMulai);
        pekerjaan.setTahunSelesai(tahunSelesai);
        return pekerjaan;
    }

}
