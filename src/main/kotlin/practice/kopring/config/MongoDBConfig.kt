package practice.kopring.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.core.mapping.MongoMappingContext
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableAutoConfiguration(exclude=[MongoAutoConfiguration::class])
@EnableMongoRepositories(basePackages = [
    "practice.kopring.repository.mongo"
])
class MongoDBConfig(
    private val mongoMappingContext: MongoMappingContext
) {

    @Value("\${spring.data.mongodb.uri}")
    private lateinit var connectionString: String

    @Bean
    fun mongoDatabaseFactory(): MongoDatabaseFactory {
        return SimpleMongoClientDatabaseFactory(connectionString)
    }

    @Bean
    fun mappingMongoConverter(
        mongoDatabaseFactory: MongoDatabaseFactory,
        mongoMappingContext: MongoMappingContext
    ): MappingMongoConverter {
        val dbRefResolver = DefaultDbRefResolver(mongoDatabaseFactory)
        val converter = MappingMongoConverter(dbRefResolver, mongoMappingContext)
        converter.setTypeMapper(DefaultMongoTypeMapper(null));
        return converter
    }

}