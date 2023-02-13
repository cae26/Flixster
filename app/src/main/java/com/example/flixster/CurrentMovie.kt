package com.example.flixster
import com.google.gson.annotations.SerializedName


class CurrentMovie {

    @JvmField
    @SerializedName("title")
    var title: String? = null

    @JvmField
    @SerializedName("release_date")
    var releaseDate: String? = null

    @SerializedName("overview")
    var overview: String? = null

    @SerializedName("poster_path")
    var posterPath: String? = null


}