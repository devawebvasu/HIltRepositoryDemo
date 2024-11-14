package com.retrofitapiimplementationwithhilt.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.retrofitapiimplementationwithhilt.Model.DataItem
import com.retrofitapiimplementationwithhilt.Model.Details
import com.retrofitapiimplementationwithhilt.Model.SubCategoryItem

@Database(entities = [SubCategoryItem::class,DataItem::class], version = 1)
abstract class FakerDB : RoomDatabase() {

    abstract fun fakkerDao() : FakerDao
}