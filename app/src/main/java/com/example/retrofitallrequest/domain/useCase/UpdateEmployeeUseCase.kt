package com.example.retrofitallrequest.domain.useCase

import com.example.retrofitallrequest.data.employee.EmployeeDto
import com.example.retrofitallrequest.domain.repository.EmployeesRepository
import retrofit2.Response
import retrofit2.http.Body
import javax.inject.Inject

class UpdateEmployeeUseCase @Inject constructor(
    private val repository: EmployeesRepository,
) {
    suspend fun updateEmployee(id: String, @Body employee: EmployeeDto): Response<EmployeeDto> {
        return repository.updateEmployee(id, employee)
    }
}