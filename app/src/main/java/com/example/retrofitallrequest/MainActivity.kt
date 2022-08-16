package com.example.retrofitallrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitallrequest.data.employee.EmployeeDto
import com.example.retrofitallrequest.databinding.ActivityMainBinding
import com.example.retrofitallrequest.presentation.App
import com.example.retrofitallrequest.presentation.adapter.EmployeesAdapter
import com.example.retrofitallrequest.presentation.viewModel.EmployeesViewModel
import com.example.retrofitallrequest.presentation.viewModel.EmployeesViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val adapter = EmployeesAdapter()
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: EmployeesViewModel
    @Inject
    lateinit var viewModelFactory: EmployeesViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this, viewModelFactory)[EmployeesViewModel::class.java]

        viewModel.getEmployees()
        viewModel.employeesList.observe(this) { employees ->
            employees?.let { adapter.submitList(it) }
        }
        viewModel.requestFailed.observe(this) {
            if (it) {
                Toast.makeText(this, "fail request", Toast.LENGTH_LONG).show()
            }
        }

        viewModel.addEmployee(EmployeeDto("25","Sergey","200000", "23"))
        viewModel.employee.observe(this){ response ->
            Log.d("test", response.toString())
        }

        viewModel.updateEmployee("1", EmployeeDto("777","Sergey","200000", "23"))
        viewModel.employee.observe(this){ response ->
            Log.d("test", response.toString())
        }

        viewModel.deleteEmployee("1")
        viewModel.employee.observe(this){ response ->
            Log.d("test", response.toString())
        }
    }
}