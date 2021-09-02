package com.example.livedata.ui.login;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.livedata.models.BaseResponse;
import com.example.livedata.models.Office;
import com.example.livedata.models.User;
import com.example.livedata.utils.ApiClient;
import com.example.livedata.utils.ApiService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<String> loginResult = new MutableLiveData<>();

    public LoginViewModel() {

    }

    public LiveData<String> loginResult(){
        return loginResult;
    }

    public void onLogin(String name, String pass) {
        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        final Call<BaseResponse<User>> call = apiService.authLogin(name,pass);
        call.enqueue(new Callback<BaseResponse<User>>() {
            @Override
            public void onResponse(@NotNull Call<BaseResponse<User>> call, @NotNull Response<BaseResponse<User>> response) {
                if (response.body() != null ) {
                    loginResult.setValue(response.body().getStatus());
                }
            }

            @Override
            public void onFailure(@NotNull Call<BaseResponse<User>> call, @NotNull Throwable t) {

            }
        });
    }

}
