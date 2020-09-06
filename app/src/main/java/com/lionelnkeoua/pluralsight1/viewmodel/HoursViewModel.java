package com.lionelnkeoua.pluralsight1.viewmodel;

import com.lionelnkeoua.pluralsight1.api.ApiClient;
import com.lionelnkeoua.pluralsight1.interfaces.ApiInterface;
import com.lionelnkeoua.pluralsight1.model.Hour;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HoursViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<Hour>> hourList;

    //we will call this method to get the data
    public LiveData<List<Hour>> getHours() {
        //if the list is null
        if (hourList == null) {
            hourList = new MutableLiveData<List<Hour>>();
            //we will load it asynchronously from server in this method
            loadHours();
        }

        //finally we will return the list
        return hourList;
    }


    private void loadHours() {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Hour>> call = apiInterface.getHours();

        call.enqueue(new Callback<List<Hour>>() {
            @Override
            public void onResponse(Call<List<Hour>> call, Response<List<Hour>> response) {
                if (response.isSuccessful() && response.body() != null){
                    hourList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Hour>> call, Throwable t) {

            }
        });
    }
}