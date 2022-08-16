package com.example.retrofitallrequest.domain.repository

import com.example.retrofitallrequest.data.employee.EmployeeDto
import com.example.retrofitallrequest.data.employee.EmployeeResponse
import retrofit2.Response
import retrofit2.http.Body

interface EmployeesRepository {
    suspend fun getAllEmployees(): Response<EmployeeResponse>
    suspend fun addEmployee(@Body employee: EmployeeDto): Response<EmployeeDto>
    suspend fun updateEmployee(id: String, @Body employee: EmployeeDto): Response<EmployeeDto>
    suspend fun deleteEmployee(id: String): Response<EmployeeDto>
}
