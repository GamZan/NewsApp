package com.example.myapplication.data.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NewsDto (
    @SerializedName("status")
    val status: String,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("section")
    val section: String,
    @SerializedName("last_updated")
    val last_updated: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val results: List<Results>
) : Serializable