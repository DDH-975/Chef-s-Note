package com.project.foodproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiService {

    //요리종류 파라미터로 데이터 받아오기

    @GET("api/{apiKey}/{serviceId}/{dataType}/{startIdx}/{endIdx}/RCP_PAT2={rcpPat2}")
    Call<DataClass> getRecipesByCategory(
            @Path("apiKey") String apiKey,
            @Path("serviceId") String serviceId,
            @Path("dataType") String dataType,
            @Path("startIdx") String startIdx,
            @Path("endIdx") String endIdx,
            @Path("rcpPat2") String rcpPat2
    );


    //메뉴명 파라미터로 데이터 받아오기
    @GET("api/{apiKey}/{serviceId}/{dataType}/{startIdx}/{endIdx}/RCP_NM={RCP_NM}")
    Call<DataClass> getRecipesByFoodName(
            @Path("apiKey") String apiKey,
            @Path("serviceId") String serviceId,
            @Path("dataType") String dataType,
            @Path("startIdx") String startIdx,
            @Path("endIdx") String endIdx,
            @Path("RCP_NM") String RCP_NM
    );

}
