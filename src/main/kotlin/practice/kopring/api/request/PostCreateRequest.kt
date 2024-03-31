package practice.kopring.api.request

data class PostCreateRequest(
    val title: String,
    val content: String,
    val thumbnail: String,
    val comments: ArrayList<String>
)
