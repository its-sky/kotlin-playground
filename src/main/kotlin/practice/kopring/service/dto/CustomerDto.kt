package practice.kopring.service.dto

import practice.kopring.domain.Customer
import practice.kopring.domain.Gender
import java.time.LocalDate

data class CustomerDto(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val birthDate: LocalDate,
) {
    companion object {
        fun from(entity: Customer): CustomerDto = CustomerDto(
            id = entity.id,
            firstName = entity.firstName,
            lastName = entity.lastName,
            gender = entity.gender,
            birthDate = entity.birthDate,
        )
    }
}
