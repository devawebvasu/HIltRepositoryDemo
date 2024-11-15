package com.retrofitapiimplementationwithhilt.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.retrofitapiimplementationwithhilt.Adapter.DataAdapter
import com.retrofitapiimplementationwithhilt.Model.DataItem
import com.retrofitapiimplementationwithhilt.Module.DatabaseModule
import com.retrofitapiimplementationwithhilt.Repository.ItemRepository.Companion.TAG
import com.retrofitapiimplementationwithhilt.ViewModel.MainViewModel
import com.retrofitapiimplementationwithhilt.databinding.ActivityDataBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class DataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataBinding
    lateinit var dataList : List<DataItem>
    lateinit var dataAdapter : DataAdapter
    lateinit var mainViewModel: MainViewModel
    lateinit var databaseModule: DatabaseModule
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.list.layoutManager = LinearLayoutManager(this)

        dataList = mutableListOf()

        databaseModule = DatabaseModule()

        dataAdapter = DataAdapter(this,dataList)

        try {
            mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
            mainViewModel.productLiveData.observe(this) {
                it?.let {
                    try {
                        databaseModule.ProvidesDatabase(this).fakkerDao().InsertData(it.data)
                        dataAdapter.setList(it.data)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                    ?:run {
                      //  databaseModule.ProvidesDatabase(applicationContext).fakkerDao().InsertData(it.data)
                        dataAdapter.setList(databaseModule.ProvidesDatabase(this).fakkerDao().getAllData())
                        Log.e(TAG, "onCreate:")
                    }
                binding.list.adapter = dataAdapter
            }
        }catch (e : Exception){
            e.printStackTrace()
        }
    }
}