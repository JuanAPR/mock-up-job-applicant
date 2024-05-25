package com.prosigmaka.backendjobapplication.model.biodata;

import com.prosigmaka.backendjobapplication.entity.biodata.BiodataEntity;
import com.prosigmaka.backendjobapplication.helper.enumerators.BersediaPenempatan;
import com.prosigmaka.backendjobapplication.helper.enumerators.GolDarah;
import com.prosigmaka.backendjobapplication.helper.enumerators.JenisKelamin;
import com.prosigmaka.backendjobapplication.model.pekerjaan.PekerjaanModel;
import com.prosigmaka.backendjobapplication.model.pelatihan.PelatihanModel;
import com.prosigmaka.backendjobapplication.model.pendidikan.PendidikanModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date; //format YYYY-MM-DD
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BiodataModel {
    private String posisi;
    private String nama;
    private String ktp;
    private String tempatLahir;
    private Date tanggalLahir;
    private JenisKelamin jenisKelamin;
    private String agama;
    private GolDarah golDarah;
    private String statusPerkawinan;
    private String alamatKtp;
    private String alamatTinggal;
    private String email;
    private String telp;
    private String kontakDarurat;
    private BersediaPenempatan bersediaPenempatan;
    private Double penghasilanMin;
    private Date tanggalBiodata;
    private List<PekerjaanModel> pekerjaanModel;
    private List<PendidikanModel> pendidikanModel;
    private List<PelatihanModel> pelatihanModel;

    public BiodataEntity dtoToEntity(){
        BiodataEntity biodata = new BiodataEntity();
        biodata.setPosisi(posisi);
        biodata.setNama(nama);
        biodata.setKtp(ktp);
        biodata.setTempatLahir(tempatLahir);
        biodata.setTanggalLahir(tanggalLahir);
        biodata.setJenisKelamin(jenisKelamin);
        biodata.setAgama(agama);
        biodata.setGolDarah(golDarah);
        biodata.setStatusPerkawinan(statusPerkawinan);
        biodata.setAlamatKtp(alamatKtp);
        biodata.setAlamatTinggal(alamatTinggal);
        biodata.setEmail(email);
        biodata.setTelp(telp);
        biodata.setKontakDarurat(kontakDarurat);
        biodata.setBersediaPenempatan(bersediaPenempatan);
        biodata.setPenghasilanMin(penghasilanMin);
        biodata.setTanggalBiodata(new Date(System.currentTimeMillis()));
        return biodata;
    }
}
