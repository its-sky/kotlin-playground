package practice.kopring.domain

import jakarta.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "post")
class Post(
    var title: String,
    var content: String,
    var thumbnail: String,
    var comments: ArrayList<String>
) {

    @Id
    var id: String ?= null

    fun addComment(comment: String) {
        comments.add(comment)
    }

}