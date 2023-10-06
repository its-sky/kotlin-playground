package practice.kopring.api.response

import practice.kopring.domain.Gender
import practice.kopring.service.dto.CustomerRegistrationDto
import java.time.LocalDate

data class CustomerRegistrationResponse(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val birthDate: LocalDate,
) {
    companion object {
        fun from(dto: CustomerRegistrationDto): CustomerRegistrationResponse =
            CustomerRegistrationResponse(
                id = dto.id,
                firstName = dto.firstName,
                lastName = dto.lastName,
                gender = dto.gender,
                birthDate = dto.birthDate,
            )
    }
}
