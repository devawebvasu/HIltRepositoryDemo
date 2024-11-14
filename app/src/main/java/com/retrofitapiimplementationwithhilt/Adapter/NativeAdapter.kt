package com.retrofitapiimplementationwithhilt.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.retrofitapiimplementationwithhilt.Model.NativeAdd
import com.retrofitapiimplementationwithhilt.Model.SubCategoryItem
import com.retrofitapiimplementationwithhilt.databinding.ItemListBinding
import com.retrofitapiimplementationwithhilt.databinding.MoreAppsItemBinding

class NativeAdapter(var context : Context,var nativeList : List<SubCategoryItem>) : RecyclerView.Adapter<NativeAdapter.NativeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NativeAdapter.NativeViewHolder {
        val MoreApps = MoreAppsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NativeViewHolder(MoreApps)
    }

    override fun onBindViewHolder(holder: NativeAdapter.NativeViewHolder, position: Int) {
        holder.Bind(nativeList[position])
    }

    override fun getItemCount(): Int {
        return nativeList.size
    }

    fun setList(nativeList: List<SubCategoryItem?>?) {
        this.nativeList = nativeList as List<SubCategoryItem>
    }

    class NativeViewHolder(var binding: MoreAppsItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun Bind(data : SubCategoryItem){
            binding.id.text = data.id.toString()
            binding.position.text = data.position.toString()
            binding.name.text = data.name
            binding.isactive.text = data.isActive.toString()
        }
    }
}