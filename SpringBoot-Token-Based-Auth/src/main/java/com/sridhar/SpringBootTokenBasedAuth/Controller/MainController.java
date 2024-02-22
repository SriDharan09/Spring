package com.sridhar.SpringBootTokenBasedAuth.Controller;


import com.sridhar.SpringBootTokenBasedAuth.Model.JWTAuthResponse;
import com.sridhar.SpringBootTokenBasedAuth.Model.LoginDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.sridhar.SpringBootTokenBasedAuth.Service.AuthService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class MainController {

    private AuthService authService;

    // Build Login REST API
    @GetMapping("/user")
    public String getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
//        String email = (String) authentication.getNameDetails();// Assuming the username is stored as the principal
        return " Hello " + username + " welcome! You are Authorised using JWT Token "  ;

    }

    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> authenticate(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }
}