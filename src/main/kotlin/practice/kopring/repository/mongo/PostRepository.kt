package practice.kopring.repository.mongo

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import practice.kopring.domain.Post
import java.util.*

@Repository
interface PostRepository: MongoRepository<Post, String> {

    override fun findById(id: String): Optional<Post>

}