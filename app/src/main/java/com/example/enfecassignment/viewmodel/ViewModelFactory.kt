package com.example.enfecassignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.enfecassignment.repository.MergedDataRepository

class ViewModelFactory(private val mergedDataRepository: MergedDataRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MergedDataViewModel::class.java)) {
            return MergedDataViewModel(mergedDataRepository) as T
        }
        throw IllegalArgumentException("Unknown Viewmodel class")

    }
}