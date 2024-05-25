package com.prosigmaka.backendjobapplication.service.pelatihan;

import com.prosigmaka.backendjobapplication.entity.biodata.PelatihanEntity;
import com.prosigmaka.backendjobapplication.helper.global.GlobalHttpResponse;
import com.prosigmaka.backendjobapplication.model.pelatihan.PelatihanResponseModel;
import com.prosigmaka.backendjobapplication.repository.PekerjaanRepo;
import com.prosigmaka.backendjobapplication.repository.PelatihanRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PelatihanService {
    private final PelatihanRepo pelatihanRepo;

    public GlobalHttpResponse<List<PelatihanResponseModel>> findAll(){
        List<PelatihanEntity> pelatihan = pelatihanRepo.findAll();
        List<PelatihanResponseModel> pelatihanModel = new ArrayList<>();
        for(PelatihanEntity data : pelatihan){
            pelatihanModel.add(data.entityToDto());
        }
        return new GlobalHttpResponse<>(200, "data retrieve success", pelatihanModel);
    }
}
