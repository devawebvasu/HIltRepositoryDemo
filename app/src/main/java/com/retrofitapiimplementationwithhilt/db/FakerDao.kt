package com.retrofitapiimplementationwithhilt.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.retrofitapiimplementationwithhilt.Model.DataItem
import com.retrofitapiimplementationwithhilt.Model.Details
import com.retrofitapiimplementationwithhilt.Model.SubCategoryItem

@Dao
interface FakerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun InsertApp(record: MutableList<SubCategoryItem?>?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun InsertData(record: List<DataItem?>?)

    @Query("Select * from SubCategoryItem")
    fun getAllApps() : List<SubCategoryItem>

    @Query("Select * from DataItem")
    fun getAllData() : List<DataItem>

}