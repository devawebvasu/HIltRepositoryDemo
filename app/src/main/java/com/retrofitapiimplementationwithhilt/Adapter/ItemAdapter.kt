package com.retrofitapiimplementationwithhilt.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.retrofitapiimplementationwithhilt.Model.SubCategoryItem
import com.retrofitapiimplementationwithhilt.databinding.ItemListBinding


class ItemAdapter(var context: Context, var Itemlist: List<SubCategoryItem?>?) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        var itemListBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(itemListBinding)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        val package_name = Itemlist?.get(position)?.appLink
        holder.Bind(Itemlist!![position]!!)

        holder.binding.download.setOnClickListener {
            try {
                val viewIntent = Intent(
                    "android.intent.action.VIEW",
                    Uri.parse("market://details?id=$package_name")
                )
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
       return Itemlist!!.size
    }

    fun setList(Itemlist: List<SubCategoryItem?>?) {
        this.Itemlist = Itemlist
        Log.d("my", Itemlist.toString())
    }

    class ItemViewHolder(var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root){
        fun Bind(data: SubCategoryItem){

            binding.star.text = data.star
            binding.installedRange.text = data.installedRange
            Glide.with(binding.root.context)
                .load(data!!.icon)
                .into(binding.icon)
            binding.name.text = data.name

//            binding.applink.text = data.get(position).appLink
//            binding.isActive.text = data.get(position).isActive.toString()
//            binding.imageActive.text = data.get(position).imageActive.toString()
//            binding.banner.text = data.get(position).banner.toString()
//            binding.id.text = data.get(position).id.toString()
//            binding.position.text = data.get(position).position.toString()
//            binding.appid.text = data.get(position).appId.toString()
//            binding.bannerimage.text = data.get(position).bannerImage

        }
    }
}