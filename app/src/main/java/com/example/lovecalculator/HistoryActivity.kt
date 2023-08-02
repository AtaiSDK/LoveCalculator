package com.example.lovecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.databinding.ActivityHistoryBinding
import com.example.lovecalculator.room.LoveDao
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryActivity : AppCompatActivity() {
    lateinit var binding : ActivityHistoryBinding

    private val viewModel: LoveViewModel by viewModels()
    @Inject
    lateinit var loveDao: LoveDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getAll().observe(this, Observer {
            binding.tvResult.text = it
        })

    }
}