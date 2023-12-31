package com.example.lovecalculator.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.example.lovecalculator.home.HomeFragment

class ResultFragment : Fragment() {
    lateinit var binding : FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        with(binding){
            if(bundle != null){
                val result = bundle.getString(HomeFragment.RESULT)
                val percentage = bundle.getString(HomeFragment.PERCENTAGE)
                val firstName = bundle.getString(HomeFragment.FIRSTNAME)
                val secondName = bundle.getString(HomeFragment.SECONDNAME)

                tvResult.text = "$percentage%"
                tvComment.text = result
                tvFirstName.text = firstName
                tvSecondName.text = secondName

            }
            backBtn.setOnClickListener {
                findNavController().navigateUp()
            }
        }

    }
    }




