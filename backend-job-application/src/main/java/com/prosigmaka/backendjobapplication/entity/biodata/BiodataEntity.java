package com.prosigmaka.backendjobapplication.entity.biodata;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.prosigmaka.backendjobapplication.entity.user.UserEntity;
import com.prosigmaka.backendjobapplication.helper.enumerators.BersediaPenempatan;
import com.prosigmaka.backendjobapplication.helper.enumerators.GolDarah;
import com.prosigmaka.backendjobapplication.helper.enumerators.JenisKelamin;
import com.prosigmaka.backendjobapplication.model.biodata.BiodataResponseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "biodata")
public class BiodataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private UserEntity userId;
    @Column(name = "posisi", nullable = false)
    private String posisi;
    @Column(name = "nama", nullable = false)
    private String nama;
    @Column(name = "ktp",nullable = false)
    private String ktp;
    @Column(name = "tempat_lahir",nullable = false)
    private String tempatLahir;
    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggalLahir;
    @Enumerated(EnumType.STRING)
    @Column(name = "jenis_kelamin", nullable = false)
    private JenisKelamin jenisKelamin;
    @Column(name = "agama", nullable = false)
    private String agama;
    @Enumerated(EnumType.STRING)
    @Column(name = "gol_dara", nullable = false)
    private GolDarah golDarah;
    @Column(name = "status_perkawinan", nullable = false)
    private String statusPerkawinan;
    @Column(name = "alamat_ktp", nullable = false)
    private String alamatKtp;
    @Column(name = "alamat_tinggal", nullable = false)
    private String alamatTinggal;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "telp", nullable = false)
    private String telp;
    @Column(name = "kontak_darurat",nullable = false)
    private String kontakDarurat;
    @Enumerated(EnumType.STRING)
    @Column(name = "bersedia_ditempatkan", nullable = false)
    private BersediaPenempatan bersediaPenempatan;
    @Column(name = "penghasilan_min", nullable = false)
    private Double penghasilanMin;
    @Column(name = "tanggal_biodata", nullable = false)
    private Date tanggalBiodata;
    @OneToMany(mappedBy = "biodataId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PendidikanEntity> pendidikanList;
    @OneToMany(mappedBy = "biodataId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PelatihanEntity> pelatihanList;
    @OneToMany(mappedBy = "biodataId")
    @JsonManagedReference
    private List<PekerjaanEntity> pekerjaanList;

    public BiodataResponseModel entityToDto(){
        BiodataResponseModel biodata = new BiodataResponseModel();
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
