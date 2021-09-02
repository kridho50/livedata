package com.example.livedata.ui.register;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.livedata.MainActivity;
import com.example.livedata.models.BaseResponse;
import com.example.livedata.utils.ApiClient;
import com.example.livedata.utils.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterViewModel extends ViewModel {

   private MutableLiveData<String> respons = new MutableLiveData<>();
   private MutableLiveData<String> validationResult = new MutableLiveData<>();

   public RegisterViewModel () {

    }

    public LiveData<String> registerResult (){
       return respons;
    }

    public LiveData<String> failUsername (){
        return validationResult;
    }

    public void register(String username, String name, String password) {
        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        final Call<BaseResponse> call = apiService.register(username, name, password);
        if (username.isEmpty() || username.length() < 5) {
            validationResult.setValue("username");
        } else if (password.isEmpty()) {
            validationResult.setValue("password");
        } else if (name.isEmpty()) {
            validationResult.setValue("name");
        } else {
            call.enqueue(new Callback<BaseResponse>() {
                @Override
                public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                    if (response.body() != null)
                        respons.setValue(response.body().getStatus());
                }

                @Override
                public void onFailure(Call<BaseResponse> call, Throwable t) {

                }
            });
        }
    }
}
