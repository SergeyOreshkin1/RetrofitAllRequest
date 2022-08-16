package com.example.retrofitallrequest.di

import com.example.retrofitallrequest.domain.repository.EmployeesRepository
import com.example.retrofitallrequest.domain.useCase.AddEmployeeUseCase
import com.example.retrofitallrequest.domain.useCase.DeleteEmployeeUseCase
import com.example.retrofitallrequest.domain.useCase.GetAllEmployeesUseCase
import com.example.retrofitallrequest.domain.useCase.UpdateEmployeeUseCase
import dagger.Module
import dagger.Provides

@Module
object UseCaseModule {
    @Provides
    fun providesGetEmployeesUseCase(
        repository: EmployeesRepository,

    ): GetAllEmployeesUseCase =
        GetAllEmployeesUseCase(repository)

    @Provides
    fun provideAddEmployeeUseCase(
        repository: EmployeesRepository,

        ): AddEmployeeUseCase =
        AddEmployeeUseCase(repository)

    @Provides
    fun provideUpdateEmployeeUseCase(
        repository: EmployeesRepository,

        ): UpdateEmployeeUseCase =
        UpdateEmployeeUseCase(repository)

    @Provides
    fun provideDeleteEmployeeUseCase(
        repository: EmployeesRepository,

        ): DeleteEmployeeUseCase =
        DeleteEmployeeUseCase(repository)

}