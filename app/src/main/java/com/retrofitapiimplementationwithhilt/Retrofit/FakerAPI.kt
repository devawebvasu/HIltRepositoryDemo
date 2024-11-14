package com.retrofitapiimplementationwithhilt.Retrofit

import com.retrofitapiimplementationwithhilt.Model.AppCenterItem
import com.retrofitapiimplementationwithhilt.Model.Details
import com.retrofitapiimplementationwithhilt.Model.MoreAppsItem
import com.retrofitapiimplementationwithhilt.Model.SubCategoryItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FakerAPI {

    @GET("com.hd.camera.apps.high.quality")
    fun SubCategoryItem() : Call<Details>

}