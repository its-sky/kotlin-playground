package practice.kopring.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.RequestMapping
import practice.kopring.api.request.PostAddCommentRequest
import practice.kopring.api.request.PostCreateRequest
import practice.kopring.api.response.PostAddCommentResponse
import practice.kopring.api.response.PostRetrieveResponse
import practice.kopring.domain.Post
import practice.kopring.repository.mongo.PostRepository
import java.net.URI

@Service
@Transactional
@RequestMapping("/api/post")
class PostService(
    private val postRepository: PostRepository
) {

    fun createPost(request: PostCreateRequest): URI {
        Post(
            title = request.title,
            content = request.content,
            thumbnail = request.thumbnail,
            comments = request.comments
        ).let {
            postRepository.save(it)
            return URI.create("/api/post/${it.id}")
        }
    }

    fun addComment(request: PostAddCommentRequest): PostAddCommentResponse {
        val post = postRepository.findByIdOrNull(request.id) ?: throw RuntimeException()
        post.addComment(request.comment)
        postRepository.save(post)

        return PostAddCommentResponse(
            title = post.title,
            content = post.content,
            thumbnail = post.thumbnail,
            comments = post.comments
        )
    }

    @Transactional(readOnly = true)
    fun retrievePost(id: String): PostRetrieveResponse? {
        val post = postRepository.findByIdOrNull(id) ?: throw NoSuchElementException("Post not found")

        return PostRetrieveResponse(
            title = post.title,
            content = post.content,
            thumbnail = post.thumbnail,
            comments = post.comments
        )
    }

}