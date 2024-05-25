package com.prosigmaka.backendjobapplication.service.auth;

import com.prosigmaka.backendjobapplication.entity.user.UserEntity;
import com.prosigmaka.backendjobapplication.helper.enumerators.Role;
import com.prosigmaka.backendjobapplication.model.auth.AuthRequestModel;
import com.prosigmaka.backendjobapplication.model.auth.AuthResponseModel;
import com.prosigmaka.backendjobapplication.model.auth.RegisterUserModel;
import com.prosigmaka.backendjobapplication.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponseModel registerUser(RegisterUserModel request){
        var user = UserEntity.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponseModel.builder()
                .token(jwtToken)
                .build();
    }
    public AuthResponseModel registerAdmin(RegisterUserModel request){
        var user = UserEntity.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();
        userRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponseModel.builder()
                .token(jwtToken)
                .build();
    }
    public AuthResponseModel authentication(AuthRequestModel requestModel){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestModel.getEmail(),
                        requestModel.getPassword()
                )
        );
        var user = userRepo.findByEmail(requestModel.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponseModel.builder()
                .token(jwtToken)
                .build();
    }
}
