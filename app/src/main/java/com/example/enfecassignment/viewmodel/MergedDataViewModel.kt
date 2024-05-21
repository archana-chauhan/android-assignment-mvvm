package com.example.enfecassignment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.enfecassignment.model.MergedData
import com.example.enfecassignment.repository.MergedDataRepository
import kotlinx.coroutines.launch

class MergedDataViewModel(private val mergedDataRepository: MergedDataRepository) : ViewModel() {

    private val _mergedData = MutableLiveData<List<MergedData>>()
    val mergedData: LiveData<List<MergedData>> get() = _mergedData

    init {
        fetchMergedData()
    }

    private fun fetchMergedData() {
        viewModelScope.launch {
            try {
                val data = mergedDataRepository.getMergedData()
                _mergedData.postValue(data)
            } catch (e: Exception) {
                Log.e("TAG", "Error in fetching data", e)
            }
        }
    }
}