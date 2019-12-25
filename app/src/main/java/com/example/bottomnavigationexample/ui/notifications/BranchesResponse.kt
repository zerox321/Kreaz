package com.example.bottomnavigationexample.ui.notifications
import com.squareup.moshi.Json


data class BranchesResponse(
    @Json(name = "data") val `data`: List<BranchesData?>?,
    @Json(name = "type") val type: String?
)

data class BranchesData(
    @Json(name = "address") val address: String?,
    @Json(name = "branch_id") val branchId: String?,
    @Json(name = "icon") val icon: String?,
    @Json(name = "img") val img: String?,
    @Json(name = "lat") val lat: String?,
    @Json(name = "lon") val lon: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "phones") val phones: List<String?>?,
    @Json(name = "times") val times: String?
)