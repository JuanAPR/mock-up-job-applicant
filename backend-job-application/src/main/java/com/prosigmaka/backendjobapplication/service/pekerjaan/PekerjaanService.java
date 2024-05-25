package com.prosigmaka.backendjobapplication.service.pekerjaan;

import com.prosigmaka.backendjobapplication.entity.biodata.PekerjaanEntity;
import com.prosigmaka.backendjobapplication.helper.global.GlobalHttpResponse;
import com.prosigmaka.backendjobapplication.model.pekerjaan.PekerjaanResponseModel;
import com.prosigmaka.backendjobapplication.repository.PekerjaanRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PekerjaanService {
    private final PekerjaanRepo pekerjaanRepo;

    public GlobalHttpResponse<List<PekerjaanResponseModel>> findAll(){
        List<PekerjaanEntity> pekerjaan = pekerjaanRepo.findAll();
        List<PekerjaanResponseModel> pekerjaanModel = new ArrayList<>();
        for(PekerjaanEntity data : pekerjaan){
            pekerjaanModel.add(data.entityToDto());
        }
        return new GlobalHttpResponse<>(200,"Data retrieve success",pekerjaanModel);
    }
}
