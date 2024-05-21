package com.example.enfecassignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.enfecassignment.adapter.MergedDataAdapter
import com.example.enfecassignment.repository.MergedDataRepository
import com.example.enfecassignment.viewmodel.MergedDataViewModel
import com.example.enfecassignment.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mergedDataAdapter: MergedDataAdapter
    private lateinit var viewModel: MergedDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = MergedDataRepository()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MergedDataViewModel::class.java]

        setupRecyclerView()
        viewModel.mergedData.observe(this) { data ->
            mergedDataAdapter.setMergedData(data)
        }
    }

    private fun setupRecyclerView() {
        mergedDataAdapter = MergedDataAdapter()
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mergedDataAdapter
        }
    }
}