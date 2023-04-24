package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("items")
    val items: List<Article>,
    @SerializedName("next_page")
    val nextPage: String,
    @SerializedName("stat")
    val stat: String,
    @SerializedName("dedup")
    val dedup: Boolean,
    @SerializedName("http_status_code")
    val httpStatusCode: Int,
    @SerializedName("generated_in")
    val generatedIn: Float,
    @SerializedName("cached_at")
    val cachedAt: Int
)





