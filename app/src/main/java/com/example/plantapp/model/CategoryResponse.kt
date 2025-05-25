package com.example.plantapp.model

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("data")
    val data: List<CategoryData>? = null
)

data class CategoryData(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("createdAt")
    val createdAt: String? = null,
    @SerializedName("updatedAt")
    val updatedAt: String? = null,
    @SerializedName("publishedAt")
    val publishedAt: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("rank")
    val rank: Int? = null,
    @SerializedName("image")
    val image: CategoryImage? = null
)

data class CategoryImage(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("alternativeText")
    val alternativeText: String? = null,
    @SerializedName("caption")
    val caption: String? = null,
    @SerializedName("width")
    val width: Int? = null,
    @SerializedName("height")
    val height: Int? = null,
    @SerializedName("formats")
    val formats: Any? = null,
    @SerializedName("hash")
    val hash: String? = null,
    @SerializedName("ext")
    val ext: String? = null,
    @SerializedName("mime")
    val mime: String? = null,
    @SerializedName("size")
    val size: Double? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("previewUrl")
    val previewUrl: String? = null,
    @SerializedName("provider")
    val provider: String? = null,
    @SerializedName("provider_metadata")
    val provider_metadata: Any? = null,
    @SerializedName("createdAt")
    val createdAt: String? = null,
    @SerializedName("updatedAt")
    val updatedAt: String? = null
)