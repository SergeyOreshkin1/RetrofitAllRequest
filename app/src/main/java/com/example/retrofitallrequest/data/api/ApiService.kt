package com.example.retrofitallrequest.data.api

import com.example.retrofitallrequest.data.employee.EmployeeDto
import com.example.retrofitallrequest.data.employee.EmployeeResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("employees")
    suspend fun getAllEmployees(): Response<EmployeeResponse>

    @POST("create")
    suspend fun createEmployee(
        @Body employee: EmployeeDto
    ): Response<EmployeeDto>

    @PUT("update/{id}")
    suspend fun updateEmployee(
        @Path("id") id: String,
        @Body employee: EmployeeDto
    ): Response<EmployeeDto>

    @DELETE("delete/{id}")
    suspend fun deleteEmployee(
        @Path("id") id: String
    ): Response<EmployeeDto>

}