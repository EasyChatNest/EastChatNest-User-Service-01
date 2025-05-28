package com.chatnest.chatnestuserservice01.service.impl;

import com.chatnest.chatnestuserservice01.common.response.ApiResponse;
import com.chatnest.chatnestuserservice01.dto.Response.SigninResponse;
import com.chatnest.chatnestuserservice01.service.LoginService;
import org.springframework.stereotype.Service;

/**
 *  Mainly handling Login in activities
 *  Check if the user has been registered
 *  Use Token to remember the status of user
 *  Then, return the Token back to the front end
 *  Use Redis remember the Token at the backend
 */

@Service
public class LoginServiceImpl implements LoginService {



    @Override
    public ApiResponse<SigninResponse> Login(SigninResponse loginRequest) {


        // check if the userName/Phone/Email has been registered


        // if NOT, reject the request, and say you have not been sign up yet


        // if YES , Check the password is correct or not


        // Save the Token at redis


        // send the response back with the Token

        return null;
    }
}
