package com.example.mykotlinaplication


import com.google.gson.annotations.SerializedName

class ResultPoker(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)