package com.lionelnkeoua.pluralsight1.interfaces;

import com.lionelnkeoua.pluralsight1.model.Hour;
import com.lionelnkeoua.pluralsight1.model.Skill;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("api/hours")
    Call<List<Hour>> getHours();

    @GET("api/skilliq")
    Call<List<Skill>> getSkills();

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formRespons")
    Call<ResponseBody>  insertData( @Field("entry.1877115667")String firstname,
                                    @Field("entry.2006916086")String lastname,
                                    @Field("entry.1824927963")String email,
                                    @Field("entry.284483984")String githubLink);
}
