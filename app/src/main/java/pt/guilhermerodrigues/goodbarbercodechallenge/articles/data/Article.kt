package pt.guilhermerodrigues.goodbarbercodechallenge.articles.data

import com.google.gson.annotations.SerializedName

data class Article (
    @SerializedName("type")
    val type: String,
    @SerializedName("subtype")
    val subtype: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("author")
    val author: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("leadin")
    val leadin: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("images")
    val images: List<Images>,
)

data class Images (
    @SerializedName("id")
    val id: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("otherImagesUrl")
    val otherImagesUrl: Map<String, String>,
)