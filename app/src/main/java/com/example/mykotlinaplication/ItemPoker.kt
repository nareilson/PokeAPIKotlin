package com.example.mykotlinaplication


import com.google.gson.annotations.SerializedName

class ItemPoker(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<ResultPoker>



)