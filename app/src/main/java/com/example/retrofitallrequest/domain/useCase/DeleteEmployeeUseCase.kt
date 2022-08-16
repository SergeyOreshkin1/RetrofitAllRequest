package com.example.retrofitallrequest.domain.useCase

import com.example.retrofitallrequest.data.employee.EmployeeDto
import com.example.retrofitallrequest.domain.repository.EmployeesRepository
import retrofit2.Response
import javax.inject.Inject

class DeleteEmployeeUseCase @Inject constructor(
    private val repository: EmployeesRepository,
) {
    suspend fun deleteEmployee(id: String): Response<EmployeeDto> {
        return repository.deleteEmployee(id)
    }
}