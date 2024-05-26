package com.prosigmaka.backendjobapplication.model.biodata;

import com.prosigmaka.backendjobapplication.model.pekerjaan.PekerjaanModel;
import com.prosigmaka.backendjobapplication.model.pelatihan.PelatihanModel;
import com.prosigmaka.backendjobapplication.model.pendidikan.PendidikanModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BiodataResponseModel {
    private String posisi;
    private String nama;
    private String ktp;
    private String tempatLahir;
    private Date tanggalLahir;
    private String jenisKelamin; //dari enum ke string?
    private String agama;
    private String golDarah;
    private String statusPerkawinan;
    private String alamatKtp;
    private String alamatTinggal;
    private String email;
    private String telp;
    private String kontakDarurat;
    private String skill;
    private String bersediaPenempatan;
    private Double penghasilanMin;
    private Date tanggalBiodata;
    private List<PekerjaanModel> pekerjaanModel;
    private List<PendidikanModel> pendidikanModel;
    private List<PelatihanModel> pelatihanModel;
}
