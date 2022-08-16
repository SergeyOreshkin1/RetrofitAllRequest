package com.example.retrofitallrequest.data.employee

import com.google.gson.annotations.SerializedName

data class EmployeeDto(
    val id: String,
    @SerializedName("employee_name") val name: String,
    @SerializedName("employee_salary") val salary: String,
    @SerializedName("employee_age") val age: String
)
