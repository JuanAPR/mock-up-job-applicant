package com.prosigmaka.backendjobapplication.service.pendidikan;

import com.prosigmaka.backendjobapplication.entity.biodata.PendidikanEntity;
import com.prosigmaka.backendjobapplication.helper.global.GlobalHttpResponse;
import com.prosigmaka.backendjobapplication.model.pendidikan.PendidikanResponseModel;
import com.prosigmaka.backendjobapplication.repository.PendidikanRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PendidikanService {
    private final PendidikanRepo pendidikanRepo;

    public GlobalHttpResponse<List<PendidikanResponseModel>> findAll(){
        List<PendidikanEntity> pendidikan = pendidikanRepo.findAll();
        List<PendidikanResponseModel> pendidikanModel = new ArrayList<>();
        for (PendidikanEntity data : pendidikan){
            pendidikanModel.add(data.entityToDto());
        }
        return new GlobalHttpResponse<>(200,"Data retrieve success",pendidikanModel);
    }
}
