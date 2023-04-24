package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models

import com.google.gson.annotations.SerializedName

data class Rubrique(
    @SerializedName("id")
    val id: Int,
    @SerializedName("label")
    val label: String,
    @SerializedName("url")
    val url: String
)