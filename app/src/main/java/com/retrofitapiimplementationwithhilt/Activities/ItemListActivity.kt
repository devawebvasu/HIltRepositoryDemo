package com.retrofitapiimplementationwithhilt.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.retrofitapiimplementationwithhilt.databinding.ActivityItemListBinding

class ItemListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityItemListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sCatagary.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.data.setOnClickListener {
            val intent = Intent(this, DataActivity::class.java)
            startActivity(intent)
        }
        binding.moreApps.setOnClickListener {
            val intent = Intent(this,NativeAdActivity::class.java)
            startActivity(intent)
        }
    }
}