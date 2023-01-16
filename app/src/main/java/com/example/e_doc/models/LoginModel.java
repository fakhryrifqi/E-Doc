package com.example.e_doc.models;

import com.google.gson.annotations.SerializedName;

public class LoginModel {
    @SerializedName("username") // => anotasi nama untuk mempresentasikan nama yang ada di json
    private String username;
    @SerializedName("password")
    private String password;

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
