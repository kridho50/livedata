package com.example.livedata.ui.home;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.livedata.models.Office;
import com.example.livedata.utils.ApiClient;
import com.example.livedata.utils.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

//    private MutableLiveData<Office> office = new MutableLiveData<>();
    private MutableLiveData<List<Office>> offices = new MutableLiveData<>();

    public HomeViewModel() {

    }

    public void getDataMakanan() {
        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        final Call<List<Office>> call = apiService.getOffice();
        call.enqueue(new Callback<List<Office>>() {
            @Override
            public void onResponse(@Nullable Call<List<Office>> call,@Nullable Response<List<Office>> response) {
                if (response.body() != null) {
                    offices.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@Nullable Call<List<Office>> call,@Nullable Throwable t) {

            }
        });
    }

    public LiveData<List<Office>> getOffices() {
        return offices;
    }
}