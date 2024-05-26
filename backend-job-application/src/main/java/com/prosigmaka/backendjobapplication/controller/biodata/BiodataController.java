package com.prosigmaka.backendjobapplication.controller.biodata;

import com.prosigmaka.backendjobapplication.helper.global.GlobalHttpResponse;
import com.prosigmaka.backendjobapplication.model.biodata.BiodataModel;
import com.prosigmaka.backendjobapplication.model.biodata.BiodataResponseModel;
import com.prosigmaka.backendjobapplication.service.biodata.BiodataService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biodata")
@RequiredArgsConstructor
public class BiodataController {
    private final BiodataService service;

    @GetMapping("/listbiodata")
    public ResponseEntity<GlobalHttpResponse<List<BiodataResponseModel>>> getBiodata(){
        var biodata = service.findAllBio();
        return new ResponseEntity<>(biodata, HttpStatusCode.valueOf(biodata.getStatus()));
    }

    @PutMapping("/updatebiodata/{name}")
    public ResponseEntity<GlobalHttpResponse<BiodataResponseModel>> getBioByName(@PathVariable("name") String name,
                                                                                 @RequestBody BiodataModel biodataModel){
        var biodata = service.updateByName(name, biodataModel);
        return new ResponseEntity<>(biodata, HttpStatusCode.valueOf(biodata.getStatus()));
    }

    @PostMapping("/addbiodata")
    public ResponseEntity<GlobalHttpResponse<BiodataResponseModel>> addBiodata(@RequestBody BiodataModel biodataModel){
        var biodata = service.addBiodataFull(biodataModel);
        return new ResponseEntity<>(biodata, HttpStatusCode.valueOf(biodata.getStatus()));
    }

    @PostMapping("/addbiodata-alter")
    public ResponseEntity<GlobalHttpResponse<BiodataResponseModel>> createBiodata(@RequestBody BiodataModel biodataModel, HttpServletRequest request){
        String token = request.getHeader("Authorization").substring(7);
        var biodata = service.createBiodata(biodataModel, token);
        return new ResponseEntity<>(biodata, HttpStatusCode.valueOf(biodata.getStatus()));
    }

    @DeleteMapping("/deletebiodata/{name}")
    public ResponseEntity<GlobalHttpResponse<BiodataResponseModel>> deleteBiodata(@PathVariable("name") String name){
        var biodata = service.deleteBiodata(name);
        return new ResponseEntity<>(biodata, HttpStatusCode.valueOf(biodata.getStatus()));
    }
}
