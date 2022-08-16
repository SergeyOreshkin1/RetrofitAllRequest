package com.example.retrofitallrequest.domain.useCase

import com.example.retrofitallrequest.data.employee.EmployeeDto
import com.example.retrofitallrequest.domain.repository.EmployeesRepository
import javax.inject.Inject

class GetAllEmployeesUseCase @Inject constructor(
    private val repository: EmployeesRepository,
) {
    suspend fun getAllEmployees(): List<EmployeeDto> {
       return repository.getAllEmployees().body()?.employees ?: emptyList()
    }
}