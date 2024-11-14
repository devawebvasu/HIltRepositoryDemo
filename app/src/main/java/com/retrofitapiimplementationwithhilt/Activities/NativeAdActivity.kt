package com.retrofitapiimplementationwithhilt.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.retrofitapiimplementationwithhilt.Adapter.NativeAdapter
import com.retrofitapiimplementationwithhilt.Model.MoreAppsItem
import com.retrofitapiimplementationwithhilt.Model.NativeAdd
import com.retrofitapiimplementationwithhilt.Model.SubCategoryItem
import com.retrofitapiimplementationwithhilt.ViewModel.MainViewModel
import com.retrofitapiimplementationwithhilt.databinding.ActivityNativeAdBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NativeAdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNativeAdBinding
    private lateinit var nativeList: List<SubCategoryItem>
    private lateinit var nativeAdapter : NativeAdapter
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNativeAdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.list.layoutManager = LinearLayoutManager(this)

        nativeList = mutableListOf()

        nativeAdapter = NativeAdapter(this, nativeList)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.productLiveData.observe(this,{
            nativeAdapter.setList(it.moreApps!![0]!!.subCategory)
            binding.list.adapter = nativeAdapter
        })
    }
}