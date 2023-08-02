package com.example.lovecalculator.home

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.*
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.remote.RetrofitService
import com.example.lovecalculator.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val viewModel: LoveViewModel by viewModels()
    @Inject
    lateinit var helper: Helper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()

    }
    private fun initClickers() {
        with(binding){
            historyBtn.setOnClickListener {
                val intent = Intent(requireContext(), HistoryActivity::class.java)
                startActivity(intent)
            }
            calculateBtn.setOnClickListener {
                 helper.showToast(requireContext(), "hello")
                viewModel.getLiveData(firstName.text.toString(), secondName.text.toString())
                    .observe(requireActivity(), Observer {
                        App.appDataBase.loveDao().insert(it)
                        val result = it.result
                        val percentage = it.percentage
                        val firstName = it.firstname
                        val secondName = it.secondname
                        if (result != null) {
                            transitionToResult(result, percentage, firstName, secondName)
                        }
                    })
            }
        }
    }
    private fun transitionToResult(result: String, percentage: String, firstName: String, secondName: String) {
        val bundle = Bundle()
        bundle.putString(RESULT, result)
        bundle.putString(PERCENTAGE, percentage)
        bundle.putString(FIRSTNAME, firstName)
        bundle.putString(SECONDNAME, secondName)
        findNavController().navigate(R.id.resultFragment, bundle)
    }

    companion object{
        const val RESULT = "result"
        const val PERCENTAGE = "percentage"
        const val FIRSTNAME = "firstName"
        const val SECONDNAME = "secondName"
    }

}