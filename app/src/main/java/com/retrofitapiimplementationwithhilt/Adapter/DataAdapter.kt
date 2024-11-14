package com.retrofitapiimplementationwithhilt.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract.RawContacts.Data
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.retrofitapiimplementationwithhilt.Model.DataItem
import com.retrofitapiimplementationwithhilt.databinding.DataItemBinding

class DataAdapter(var context : Context,var dataList : List<DataItem>) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        var dataItemBinding = DataItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder(dataItemBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        val package_name = dataList[position].packageName
        holder.Bind(dataList[position])

        holder.binding.download.setOnClickListener {
            try {

                val viewIntent = Intent("android.intent.action.VIEW",Uri.parse("market://details?id=$package_name"))
                context.startActivity(viewIntent)

            } catch (e: Exception) {
                Toast.makeText(
                    context, "Unable to Connect Try Again...",
                    Toast.LENGTH_LONG
                ).show()
                e.printStackTrace()
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList!!.size
    }

    fun setList(dataList: List<DataItem?>?) {
        this.dataList = dataList as List<DataItem>

    }
    class DataViewHolder(var binding: DataItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun Bind(data : DataItem){
            Glide.with(binding.root.context)
                .load(data.thumbImage)
                .into(binding.image)
            binding.id.text = data.id.toString()
            binding.position.text = data.position.toString()
            binding.name.text = data.name
        }
    }
}