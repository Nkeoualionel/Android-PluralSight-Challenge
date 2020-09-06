package com.lionelnkeoua.pluralsight1.viewmodel;

import com.lionelnkeoua.pluralsight1.api.ApiClient;
import com.lionelnkeoua.pluralsight1.interfaces.ApiInterface;
import com.lionelnkeoua.pluralsight1.model.Hour;
import com.lionelnkeoua.pluralsight1.model.Skill;

import java.util.List;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillsViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<Skill>> skillList;

    //we will call this method to get the data
    public LiveData<List<Skill>> getSkills() {
        //if the list is null
        if (skillList == null) {
            skillList = new MutableLiveData<List<Skill>>();
            //we will load it asynchronously from server in this method
            loadSkills();
        }

        //finally we will return the list
        return skillList;
    }


    private void loadSkills() {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Skill>> call = apiInterface.getSkills();

        call.enqueue(new Callback<List<Skill>>() {
            @Override
            public void onResponse(Call<List<Skill>> call, Response<List<Skill>> response) {
                if (response.isSuccessful() && response.body() != null){
                    skillList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Skill>> call, Throwable t) {

            }
        });
    }
}