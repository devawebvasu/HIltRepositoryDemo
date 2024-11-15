package com.retrofitapiimplementationwithhilt.Activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.retrofitapiimplementationwithhilt.Adapter.DataAdapter
import com.retrofitapiimplementationwithhilt.Adapter.ItemAdapter
import com.retrofitapiimplementationwithhilt.Model.DataItem
import com.retrofitapiimplementationwithhilt.Model.SubCategoryItem
import com.retrofitapiimplementationwithhilt.Module.DatabaseModule
import com.retrofitapiimplementationwithhilt.ViewModel.MainViewModel
import com.retrofitapiimplementationwithhilt.databinding.ActivityMainBinding
import com.retrofitapiimplementationwithhilt.db.FakerDB
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var dataList : List<DataItem>
    lateinit var dataAdapter : DataAdapter
    lateinit var mainViewModel2: MainViewModel
    lateinit var databaseModule2: DatabaseModule

    lateinit var mainViewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding
    lateinit var fakerDB: FakerDB
    lateinit var itemAdapter: ItemAdapter
    lateinit var databaseModule: DatabaseModule

    var Itemlist: List<SubCategoryItem?>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.list.layoutManager = LinearLayoutManager(this)

        Itemlist = mutableListOf()

        databaseModule = DatabaseModule()

        itemAdapter = ItemAdapter(this, Itemlist)
        Log.d("Item are   gggc hiii", itemAdapter.Itemlist.toString())
        try {
            mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

            mainViewModel.productLiveData.observe(this) {
                it?.let {
                    Log.d("data", it.toString())
                    databaseModule.ProvidesDatabase(this).fakkerDao().InsertApp(it!!.appCenter!![0]!!.subCategory)
                    try {

                        itemAdapter.setList(it!!.appCenter!![0]!!.subCategory)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                } ?: run {
                    itemAdapter.setList(databaseModule.ProvidesDatabase(this).fakkerDao().getAllApps())
                }
                binding.list.adapter = itemAdapter
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        binding.list2.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        dataList = mutableListOf()

        databaseModule2 = DatabaseModule()
        dataAdapter = DataAdapter(this,dataList)

        try {
            mainViewModel2 = ViewModelProvider(this).get(MainViewModel::class.java)
            mainViewModel2.productLiveData.observe(this) {
                it?.let {
                    try {
                        databaseModule2.ProvidesDatabase(this).fakkerDao().InsertData(it.data)
                        dataAdapter.setList(it.data)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                    ?:run {
                        //  databaseModule.ProvidesDatabase(applicationContext).fakkerDao().InsertData(it.data)
                        dataAdapter.setList(databaseModule2.ProvidesDatabase(this).fakkerDao().getAllData())
                    }
                binding.list2.adapter = dataAdapter
            }
        }catch (e : Exception){
            e.printStackTrace()
        }
    }
}