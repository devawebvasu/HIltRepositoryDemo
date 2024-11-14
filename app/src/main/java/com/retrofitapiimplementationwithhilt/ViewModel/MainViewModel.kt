package com.retrofitapiimplementationwithhilt.ViewModel

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retrofitapiimplementationwithhilt.Model.Details
import com.retrofitapiimplementationwithhilt.Repository.ItemRepository
import com.retrofitapiimplementationwithhilt.db.FakerDB
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject  constructor(@ApplicationContext context: Context,var repository: ItemRepository,var fakerDB: FakerDB) : ViewModel() {

    val productLiveData = MutableLiveData<Details>()

    init {
        viewModelScope.launch {

            // Log.d("Record", repository.getSubCatagoryItem().toString())
            productLiveData.postValue(repository.getSubCatagoryItem())

        }
    }
}