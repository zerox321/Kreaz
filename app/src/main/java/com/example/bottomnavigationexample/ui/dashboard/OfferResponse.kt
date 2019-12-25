package com.example.bottomnavigationexample.ui.dashboard
import com.squareup.moshi.Json


data class OfferResponse(
    @Json(name = "data") val `data`: List<OfferData?>?,
    @Json(name = "type") val type: String?
)

data class OfferData(
    @Json(name = "address") val address: String?,
    @Json(name = "branch_id") val branchId: String?,
    @Json(name = "date") val date: String?,
    @Json(name = "icon") val icon: String?,
    @Json(name = "img") val img: String?,
    @Json(name = "lat") val lat: String?,
    @Json(name = "lon") val lon: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "offer_id") val offerId: String?,
    @Json(name = "offer_img") val offerImg: String?,
    @Json(name = "phones") val phones: List<String?>?,
    @Json(name = "times") val times: String?,
    @Json(name = "valid") val valid: Int?
)