package com.prosigmaka.backendjobapplication.controller.auth;

import com.prosigmaka.backendjobapplication.model.auth.AuthRequestModel;
import com.prosigmaka.backendjobapplication.model.auth.AuthResponseModel;
import com.prosigmaka.backendjobapplication.model.auth.RegisterUserModel;
import com.prosigmaka.backendjobapplication.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register-user")
    public ResponseEntity<AuthResponseModel> registerUser(@Valid @RequestBody RegisterUserModel register){
        return ResponseEntity.ok(authService.registerUser(register));
    }

    @PostMapping("/register-admin")
    public ResponseEntity<AuthResponseModel> registerAdmin(@Valid @RequestBody RegisterUserModel register){
        return ResponseEntity.ok(authService.registerAdmin(register));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseModel> authenticate(@Valid @RequestBody AuthRequestModel requestModel){
        return ResponseEntity.ok(authService.authentication(requestModel));
    }
}
