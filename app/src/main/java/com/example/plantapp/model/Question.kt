package com.example.plantapp.model

import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("subtitle")
    val subtitle: String? = null,
    @SerializedName("image_uri")
    val imageUri: String? = null,
    @SerializedName("uri")
    val uri: String? = null,
    @SerializedName("order")
    val order: Int? = null
)

typealias QuestionsResponse = List<Question>