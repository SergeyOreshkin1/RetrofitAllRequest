package com.example.retrofitallrequest.domain.useCase

import com.example.retrofitallrequest.data.employee.EmployeeDto
import com.example.retrofitallrequest.data.employee.EmployeeResponse
import com.example.retrofitallrequest.domain.repository.EmployeesRepository
import retrofit2.Response
import retrofit2.http.Body
import javax.inject.Inject

class AddEmployeeUseCase @Inject constructor(
    private val repository: EmployeesRepository,
) {
    suspend fun addEmployee(@Body employee: EmployeeDto): Response<EmployeeDto> {
        return repository.addEmployee(employee)
    }
}