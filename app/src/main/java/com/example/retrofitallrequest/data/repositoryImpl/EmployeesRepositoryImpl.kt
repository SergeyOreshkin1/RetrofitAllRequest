package com.example.retrofitallrequest.data.repositoryImpl

import com.example.retrofitallrequest.data.api.ApiService
import com.example.retrofitallrequest.data.employee.EmployeeDto
import com.example.retrofitallrequest.data.employee.EmployeeResponse
import com.example.retrofitallrequest.domain.repository.EmployeesRepository
import retrofit2.Response
import retrofit2.http.Body
import javax.inject.Inject

class EmployeesRepositoryImpl @Inject constructor(private val serviceAPI: ApiService) :
    EmployeesRepository {
    override suspend fun getAllEmployees(): Response<EmployeeResponse> {
        return serviceAPI.getAllEmployees()
    }

    override suspend fun addEmployee(@Body employee: EmployeeDto): Response<EmployeeDto> {
        return serviceAPI.createEmployee(employee)
    }

    override suspend fun updateEmployee(id: String, @Body employee: EmployeeDto): Response<EmployeeDto> {
        return serviceAPI.updateEmployee(id, employee)
    }

    override suspend fun deleteEmployee(id: String): Response<EmployeeDto> {
        return serviceAPI.deleteEmployee(id)
    }
}