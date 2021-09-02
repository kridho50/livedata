package com.example.livedata.models;

import com.google.gson.annotations.SerializedName;

public class User {

    /**
     * id_user : 1
     * username : kridho
     * nama : kridho cokro
     */

    @SerializedName("id_user")
    private String idUser;
    @SerializedName("username")
    private String username;
    @SerializedName("nama")
    private String nama;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
