package com.example.e_doc.repositories;

import com.example.e_doc.models.LoginModel;
import com.example.e_doc.request.Servicey;
import com.example.e_doc.response.LoginResponse;
import com.example.e_doc.utils.ILoginService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Class ini untuk remote API agar dapat berkomunikasi dengan data source
public class LoginRepository {
    public void loginRemote(LoginModel loginModel, ILoginResponse iLoginResponse){
        ILoginService iLoginService = Servicey.getRetrofit().create(ILoginService.class);
        Call<LoginResponse> initLogin = iLoginService.login(loginModel);

        initLogin.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                // re-check login successful
                if (response.isSuccessful()){
                    iLoginResponse.onResponse(response.body());
                } else {
                    iLoginResponse.onFailure(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                iLoginResponse.onFailure(t);
            }
        });
    }

    public interface ILoginResponse{
        void onResponse(LoginResponse loginResponse);
        void onFailure(Throwable t);
    }
}
