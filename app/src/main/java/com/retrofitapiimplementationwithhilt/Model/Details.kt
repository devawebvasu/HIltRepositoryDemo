package com.retrofitapiimplementationwithhilt.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Details(

	@PrimaryKey
	var id : Int? = null,

	@field:SerializedName("more_apps")
	val moreApps: List<MoreAppsItem?>? = null,

	@field:SerializedName("native_add")
	val nativeAdd: NativeAdd? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("translator_ads_id")
	val translatorAdsId: TranslatorAdsId? = null,

	@field:SerializedName("app_center")
	val appCenter: List<AppCenterItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null,

	@field:SerializedName("home")
	val home: List<HomeItem?>? = null
)

@Entity
data class SubCategoryItem(


	@field:SerializedName("app_link")
	val appLink: String? = null,

	@field:SerializedName("is_active")
	val isActive: Int? = null,

	@field:SerializedName("star")
	val star: String? = null,

	@field:SerializedName("image_active")
	val imageActive: Int? = null,

	@field:SerializedName("installed_range")
	val installedRange: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("banner")
	val banner: String? = null,

	@PrimaryKey
	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("position")
	val position: Int? = null,

	@field:SerializedName("app_id")
	val appId: Int? = null,

	@field:SerializedName("banner_image")
	val bannerImage: String? = null
)
data class NativeAdd(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("is_active")
	val isActive: Int? = null,

	@field:SerializedName("image_active")
	val imageActive: Int? = null,

	@field:SerializedName("package_name")
	val packageName: String? = null,

	@field:SerializedName("playstore_link")
	val playstoreLink: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("position")
	val position: Int? = null
)

data class TranslatorAdsId(

	@field:SerializedName("interstitial")
	val interstitial: String? = null,

	@field:SerializedName("banner")
	val banner: String? = null
)

@Entity
data class DataItem(

	@field:SerializedName("app_link")
	val appLink: String? = null,

	@field:SerializedName("full_thumb_image")
	val fullThumbImage: String? = null,

	@field:SerializedName("thumb_image")
	val thumbImage: String? = null,

	@field:SerializedName("splash_active")
	val splashActive: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("package_name")
	val packageName: String? = null,

	@PrimaryKey
	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("position")
	val position: Int? = null,

	@field:SerializedName("app_id")
	val appId: Int? = null
)

@Entity
data class AppCenterItem(

	@field:SerializedName("is_active")
	val isActive: Int? = null,

	@field:SerializedName("sub_category")
	val subCategory: MutableList<SubCategoryItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("position")
	val position: Int? = null,

	@field:SerializedName("catgeory")
	val catgeory: String? = null
)

@Entity
data class HomeItem(

	@field:SerializedName("is_active")
	val isActive: Int? = null,

	@field:SerializedName("sub_category")
	val subCategory: List<SubCategoryItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("position")
	val position: Int? = null,

	@field:SerializedName("catgeory")
	val catgeory: String? = null
)

@Entity
data class MoreAppsItem(

	@field:SerializedName("is_active")
	val isActive: Int? = null,

	@field:SerializedName("sub_category")
	val subCategory: List<SubCategoryItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("position")
	val position: Int? = null,

	@field:SerializedName("catgeory")
	val catgeory: String? = null
)
