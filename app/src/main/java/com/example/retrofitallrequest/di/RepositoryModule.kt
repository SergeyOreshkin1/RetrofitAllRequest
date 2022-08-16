package com.example.retrofitallrequest.di

import com.example.retrofitallrequest.data.repositoryImpl.EmployeesRepositoryImpl
import com.example.retrofitallrequest.domain.repository.EmployeesRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindsEmployeesRepository(implementation:EmployeesRepositoryImpl): EmployeesRepository
}