package practice.kopring.api.response

data class PostAddCommentResponse(
    val title: String,
    val content: String,
    val thumbnail: String,
    val comments: ArrayList<String>
)
