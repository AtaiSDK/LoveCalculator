package com.example.lovecalculator.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.Pref
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentOnBoardBinding
import com.example.lovecalculator.home.HomeFragment

class OnBoardFragment : Fragment() {
    private val adapter = BoardAdapter(this::onClick)
    private lateinit var binding : FragmentOnBoardBinding
    private val pref : Pref by lazy {
        Pref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pager.adapter = adapter
        binding.indicator.setViewPager(binding.pager)
    }
    private fun onClick() {
        pref.saveSeen()
        findNavController().navigateUp()
    }
}