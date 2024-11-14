package com.retrofitapiimplementationwithhilt.Repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.retrofitapiimplementationwithhilt.Model.Details
import com.retrofitapiimplementationwithhilt.Retrofit.FakerAPI
import com.retrofitapiimplementationwithhilt.db.FakerDB
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


class ItemRepository @Inject constructor(var fakerAPI: FakerAPI, var fakerDB: FakerDB) {

    companion object{
        const val TAG = "ItemRepository"
    }
    suspend fun getSubCatagoryItem(): Details? {
        return suspendCoroutine {
            try {
                val call = fakerAPI.SubCategoryItem()
                call.enqueue(object : Callback<Details?> {
                    override fun onResponse(call: Call<Details?>, response: Response<Details?>) {
                        it.resume(response.body())
                    }

                    override fun onFailure(call: Call<Details?>, t: Throwable) {
                        it.resumeWithException(t)
                        Log.d(TAG,"ItemRepository"+t.toString())
                    }

                })

            } catch (e: Exception) {
                Log.e("ItemRepository", "getSubCatagoryItem: ${e.message}")
            }
        }
    }
}