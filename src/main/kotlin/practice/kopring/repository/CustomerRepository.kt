package practice.kopring.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import practice.kopring.domain.Customer
import practice.kopring.domain.Gender
import java.util.Optional

@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {
    fun findByGender(gender: Gender): Customer?
    fun findByFirstName(firstName: String): Optional<Customer>
}