package com.example.bottomnavigationexample.ui.home
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


data class CategoryResponse(
    @Json(name = "data") val `data`: List<CategoryData?>?,
    @Json(name = "type") val type: String?
)
@Parcelize
data class CategoryData(
    @Json(name = "icon") val icon: String?,
    @Json(name = "id") val id: String?,
    @Json(name = "items") val items: List<Item?>?,
    @Json(name = "name") val name: String?,
    @Json(name = "total_items") val totalItems: String?
): Parcelable

@Parcelize
data class Item(
    @Json(name = "des") val des: String?,
    @Json(name = "id") val id: String?,
    @Json(name = "img") val img: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "price") val price: String?,
    @Json(name = "unit") val unit: String?
): Parcelable
