package com.lionelnkeoua.pluralsight1.interfaces;

import com.lionelnkeoua.pluralsight1.model.Hour;
import com.lionelnkeoua.pluralsight1.model.Skill;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api/hours")
    Call<List<Hour>> getHours();

    @GET("api/skilliq")
    Call<List<Skill>> getSkills();
}
