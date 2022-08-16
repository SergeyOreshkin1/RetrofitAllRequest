package com.example.retrofitallrequest.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitallrequest.data.employee.EmployeeDto
import com.example.retrofitallrequest.databinding.EmployeesItemLayoutBinding

private val diffCallBack = object : DiffUtil.ItemCallback<EmployeeDto>() {

    override fun areItemsTheSame(oldItem: EmployeeDto, newItem: EmployeeDto):
            Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: EmployeeDto, newItem: EmployeeDto):
            Boolean = oldItem == newItem
}

class EmployeesAdapter(var listener: (EmployeeDto) -> Unit = {}) :
    ListAdapter<EmployeeDto, EmployeesAdapter.EmployeesViewHolder>(diffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesViewHolder {
        return EmployeesViewHolder(
            EmployeesItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EmployeesViewHolder, position: Int) {
        holder.bind(getItem(position))

        holder.itemView.setOnClickListener {
            listener(getItem(position))
        }
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    class EmployeesViewHolder(private val binding: EmployeesItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: EmployeeDto) {
            binding.itemId.text = item.id
            binding.itemName.text = item.name
            binding.itemAge.text = item.age
            binding.itemSalary.text = item.salary
        }
    }
}
