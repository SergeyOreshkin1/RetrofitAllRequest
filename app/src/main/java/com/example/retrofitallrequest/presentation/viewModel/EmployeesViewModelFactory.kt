package com.example.retrofitallrequest.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitallrequest.domain.useCase.AddEmployeeUseCase
import com.example.retrofitallrequest.domain.useCase.DeleteEmployeeUseCase
import com.example.retrofitallrequest.domain.useCase.GetAllEmployeesUseCase
import com.example.retrofitallrequest.domain.useCase.UpdateEmployeeUseCase
import javax.inject.Inject

class EmployeesViewModelFactory @Inject constructor(
    private val getUseCase: GetAllEmployeesUseCase,
    private val addUseCase: AddEmployeeUseCase,
    private val updateUseCase: UpdateEmployeeUseCase,
    private val deleteUseCase: DeleteEmployeeUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeesViewModel(getUseCase, addUseCase, updateUseCase, deleteUseCase) as T
    }
}