package com.sridhar.SpringBootTokenBasedAuth.Service;

import com.sridhar.SpringBootTokenBasedAuth.Model.LoginDto;


public interface AuthService {
    String login(LoginDto loginDto);
}