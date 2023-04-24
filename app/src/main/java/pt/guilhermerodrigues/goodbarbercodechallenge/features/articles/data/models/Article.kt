package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models

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
    val images: List<Image>,
    @SerializedName("isFeatured")
    val isFeatured: String,
    @SerializedName("smallThumbnail")
    val smallThumbnail: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("originalThumbnail")
    val originalThumbnail: String,
    @SerializedName("largeThumbnail")
    val largeThumbnail: String,
    @SerializedName("xLargeThumbnail")
    val xLargeThumbnail: String,
    @SerializedName("xxLargeThumbnail")
    val xxLargeThumbnail: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("isHeadline")
    val isHeadline: Int,
    @SerializedName("authorAvatarUrl")
    val authorAvatarUrl: String,
    @SerializedName("rubrique")
    val rubrique: Rubrique,
    @SerializedName("commentsEnabled")
    val commentsEnabled: Boolean,
    @SerializedName("commentsPostUrl")
    val commentsPostUrl: String,
    @SerializedName("commentsUrl")
    val commentsUrl: String,
    @SerializedName("nbcomments")
    val nbComments: Int,
    @SerializedName("url")
    val url: String
)