package com.prosigmaka.backendjobapplication.service.biodata;

import com.prosigmaka.backendjobapplication.entity.biodata.BiodataEntity;
import com.prosigmaka.backendjobapplication.entity.biodata.PekerjaanEntity;
import com.prosigmaka.backendjobapplication.entity.biodata.PelatihanEntity;
import com.prosigmaka.backendjobapplication.entity.biodata.PendidikanEntity;
import com.prosigmaka.backendjobapplication.helper.global.GlobalHttpResponse;
import com.prosigmaka.backendjobapplication.model.biodata.BiodataModel;
import com.prosigmaka.backendjobapplication.model.biodata.BiodataResponseModel;
import com.prosigmaka.backendjobapplication.repository.BiodataRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BiodataService {
    private final BiodataRepo biodataRepo;

    //find all data and show them
    public GlobalHttpResponse<List<BiodataResponseModel>> findAll(){
        List<BiodataEntity> biodata = biodataRepo.findAll();
        List<BiodataResponseModel> biodataModel = new ArrayList<>();
        for(BiodataEntity data : biodata){
            biodataModel.add(data.entityToDto());
        }
        return new GlobalHttpResponse<>(200,"data retrieve success",biodataModel);
    }
    //add new data
    public GlobalHttpResponse<BiodataResponseModel> addBiodata(BiodataModel biodataModel){
        BiodataEntity biodata = biodataRepo.save(biodataModel.dtoToEntity());
        return new GlobalHttpResponse<>(201,"Biodata saved",biodata.entityToDto());
    }
    //add new data, but with for loop for each List in Riwayat Pendidikan, Pelatihan dan Pekerjaan
    public GlobalHttpResponse<BiodataResponseModel> addBiodataFull (BiodataModel biodataModel){
        BiodataEntity biodata = biodataModel.dtoToEntity();
        List<PendidikanEntity> pendidikanEntity = new ArrayList<>();
        List<PelatihanEntity> pelatihanEntity = new ArrayList<>();
        List<PekerjaanEntity> pekerjaanEntity = new ArrayList<>();
    }

    //update biodata
    public GlobalHttpResponse<BiodataResponseModel> updateByName(String name, BiodataModel biodataModel){
        Optional<BiodataEntity> entity = biodataRepo.findByNama(name);
        if(entity.isEmpty()){
            return new GlobalHttpResponse<>(404,"Data not found", new BiodataEntity().entityToDto());
        } else {
            BiodataEntity biodataEntity = entity.get();
            biodataEntity.setPosisi(biodataModel.getPosisi());
            biodataEntity.setNama(biodataModel.getNama());
            biodataEntity.setKtp(biodataModel.getKtp());
            biodataEntity.setTempatLahir(biodataModel.getTempatLahir());
            biodataEntity.setTanggalLahir(biodataModel.getTanggalLahir());
            biodataEntity.setJenisKelamin(biodataModel.getJenisKelamin());
            biodataEntity.setAgama(biodataModel.getAgama());
            biodataEntity.setGolDarah(biodataModel.getGolDarah());
            biodataEntity.setStatusPerkawinan(biodataModel.getStatusPerkawinan());
            biodataEntity.setAlamatKtp(biodataModel.getAlamatKtp());
            biodataEntity.setAlamatTinggal(biodataModel.getAlamatTinggal());
            biodataEntity.setEmail(biodataModel.getEmail());
            biodataEntity.setTelp(biodataModel.getTelp());
            biodataEntity.setKontakDarurat(biodataModel.getKontakDarurat());
            biodataEntity.setBersediaPenempatan(biodataModel.getBersediaPenempatan());
            biodataEntity.setPenghasilanMin(biodataModel.getPenghasilanMin());
            BiodataEntity result = biodataRepo.save(biodataEntity);
            return new GlobalHttpResponse<>(200,"Data updated",result.entityToDto());
        }
    }
    public GlobalHttpResponse<BiodataResponseModel> deleteBiodata(String name){
        Optional<BiodataEntity> biodata = biodataRepo.findByNama(name);
        if(biodata.isEmpty()){
            return new GlobalHttpResponse<>(404,"Biodata not found",null);
        } else {
            BiodataEntity entity = biodata.get();
            biodataRepo.deleteByNama(name);
            return new GlobalHttpResponse<>(200,"Delete Success",null);
        }
    }
}
