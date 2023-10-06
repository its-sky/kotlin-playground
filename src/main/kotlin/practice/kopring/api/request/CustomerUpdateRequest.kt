package practice.kopring.api.request

import jakarta.annotation.Nullable
import practice.kopring.domain.Gender
import java.time.LocalDate

data class CustomerUpdateRequest(
    val firstName: String,
    @Nullable
    val lastName: String,
    @Nullable
    val gender: Gender,
    @Nullable
    val birthDate: LocalDate,
)
