package com.example.retrofitallrequest.data.employee

import com.google.gson.annotations.SerializedName

data class EmployeeResponse(
    @SerializedName("data") val employees: List<EmployeeDto>
)
