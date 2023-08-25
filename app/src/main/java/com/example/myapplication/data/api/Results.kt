package com.example.myapplication.data.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Results (
    @SerializedName("title")
    val title: String,
    @SerializedName("abstract")
    val abstract: String,
    @SerializedName("multimedia")
    val multimedia: List<Multimedia>
) : Serializable