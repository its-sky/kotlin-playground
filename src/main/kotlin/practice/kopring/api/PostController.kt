package practice.kopring.api

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import practice.kopring.api.request.PostAddCommentRequest
import practice.kopring.api.request.PostCreateRequest
import practice.kopring.api.response.PostAddCommentResponse
import practice.kopring.api.response.PostRetrieveResponse
import practice.kopring.service.PostService
import java.net.URI

@Controller
@RequestMapping("/api/post")
class PostController(
    private val postService: PostService
) {

    @PostMapping
    fun createPost(@RequestBody request: PostCreateRequest): ResponseEntity<URI> =
        ResponseEntity.created(postService.createPost(request)).build()

    @PostMapping("/comment")
    fun addComment(@RequestBody request: PostAddCommentRequest): ResponseEntity<PostAddCommentResponse> =
        ResponseEntity.ok().body(postService.addComment(request))

    @GetMapping("/{id}")
    fun retrievePost(@PathVariable id: String): ResponseEntity<PostRetrieveResponse> =
        ResponseEntity.ok().body(postService.retrievePost(id))

}