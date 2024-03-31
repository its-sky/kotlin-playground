package practice.kopring.api.response

data class PostRetrieveResponse(
    val title: String,
    val content: String,
    val thumbnail: String,
    val comments: ArrayList<String>
)
