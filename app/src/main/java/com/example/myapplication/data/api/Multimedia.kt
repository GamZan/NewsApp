package com.example.myapplication.data.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Multimedia(
    @SerializedName("url")
    val photoUrl: String
) : Serializable
