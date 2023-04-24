package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models

import com.google.gson.annotations.SerializedName


data class Image(
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("otherImagesUrl")
    val otherImagesUrl: OtherImagesUrl
)

data class OtherImagesUrl(
    @SerializedName("large")
    val large: String
)
