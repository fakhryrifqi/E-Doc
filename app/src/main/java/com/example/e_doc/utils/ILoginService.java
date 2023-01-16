package com.example.e_doc.utils;

import com.example.e_doc.models.LoginModel;
import com.example.e_doc.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ILoginService {
    @POST("/api/auth/generate_token")
    Call<LoginResponse> login(@Body LoginModel loginModel);
}
