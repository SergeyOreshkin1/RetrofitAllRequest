package com.example.retrofitallrequest.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitallrequest.data.employee.EmployeeDto
import com.example.retrofitallrequest.data.employee.EmployeeResponse
import com.example.retrofitallrequest.domain.useCase.AddEmployeeUseCase
import com.example.retrofitallrequest.domain.useCase.DeleteEmployeeUseCase
import com.example.retrofitallrequest.domain.useCase.GetAllEmployeesUseCase
import com.example.retrofitallrequest.domain.useCase.UpdateEmployeeUseCase
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.Body
import javax.inject.Inject

class EmployeesViewModel @Inject constructor(
    private val getAllEmployeesUseCase: GetAllEmployeesUseCase,
    private val addEmployeeUseCase: AddEmployeeUseCase,
    private val updateEmployeeUseCase: UpdateEmployeeUseCase,
    private val deleteEmployeeUseCase: DeleteEmployeeUseCase
) : ViewModel() {

    private var _employeesList = MutableLiveData<List<EmployeeDto>?>()
    val employeesList: LiveData<List<EmployeeDto>?> = _employeesList
    val requestFailed: MutableLiveData<Boolean> = MutableLiveData(false)

    private val _employee = MutableLiveData<EmployeeDto>()
    val employee: LiveData<EmployeeDto> = _employee


    fun getEmployees() {
        viewModelScope.launch {
            try {
                if (_employeesList.value == null) {
                    _employeesList.value = getAllEmployeesUseCase.getAllEmployees()
                }
            } catch (ex: Exception) {
                requestFailed.postValue(true)
            }
        }
    }

    fun addEmployee(employee: EmployeeDto) {
        viewModelScope.launch {
            try {
                if (_employee.value == null) {
                    _employee.value = addEmployeeUseCase.addEmployee(employee).body()
                }
            } catch (ex: Exception) {
                requestFailed.postValue(true)
            }
        }
    }

    fun updateEmployee(id: String, employee: EmployeeDto) {
        viewModelScope.launch {
            try {
                if (_employee.value == null) {
                    _employee.value = updateEmployeeUseCase.updateEmployee(id, employee).body()
                }
            } catch (ex: Exception) {
                requestFailed.postValue(true)
            }
        }
    }

    fun deleteEmployee(id: String) {
        viewModelScope.launch {
            try {
                if (_employee.value == null) {
                    _employee.value = deleteEmployeeUseCase.deleteEmployee(id).body()
                }
            } catch (ex: Exception) {
                requestFailed.postValue(true)
            }
        }
    }

}