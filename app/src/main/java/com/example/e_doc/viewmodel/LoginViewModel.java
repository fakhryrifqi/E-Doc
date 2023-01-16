package com.example.e_doc.viewmodel;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_doc.models.LoginModel;
import com.example.e_doc.repositories.LoginRepository;
import com.example.e_doc.response.LoginResponse;

// Class ini digunakan untuk memanggil repository untuk login
public class LoginViewModel extends ViewModel {
    MutableLiveData<Integer> mProgress = new MutableLiveData<>();
//    MutableLiveData<String> mLogin = new MutableLiveData<>();
    LoginRepository mLoginRepository;

    public LoginViewModel(){
        mProgress.postValue(View.INVISIBLE);
//        mLogin.postValue("Not logged in");
        mLoginRepository = new LoginRepository();
    }

    public void login(String username, String password){
        mProgress.postValue(View.VISIBLE);
//        mLogin.postValue("Checking");
        mLoginRepository.loginRemote(new LoginModel(username, password), new LoginRepository.ILoginResponse() {
            @Override
            public void onResponse(LoginResponse loginResponse) {
                mProgress.postValue(View.INVISIBLE);
//                mLogin.postValue("Login Successfully");
            }

            @Override
            public void onFailure(Throwable t) {
                mProgress.postValue(View.INVISIBLE);
//                mLogin.postValue("Login Failed: " + t.getLocalizedMessage());
            }
        });
    }

//    public LiveData<String> getLogin(){
//        return mLogin;
//    }
}
