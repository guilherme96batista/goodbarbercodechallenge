package pt.guilhermerodrigues.goodbarbercodechallenge.articles.data

data class Article (
    val type: String,
    val subtype: String,
    val id: Int,
    val author: String,
    val title: String,
    val date: String,
    val leadin: String,
    val summary: String,
    val content: String,
    val images: List<Images>,
)

data class Images (
    val id: Int,
    val url: String,
    val otherImagesUrl: Map<String, String>,
)