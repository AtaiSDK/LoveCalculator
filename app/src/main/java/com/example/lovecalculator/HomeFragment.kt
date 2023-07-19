package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentHomeBinding
import com.example.lovecalculator.result.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding


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
            calculateBtn.setOnClickListener {

                RetrofitService().api.getPercentage(
                    firstName.text.toString(),
                    secondName.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        val result = response.body()?.result.toString()
                        val percentage = response.body()?.percentage.toString()
                        if (result != null) {
                            transitionToResult(result, percentage)
                            firstName.text.clear()
                            secondName.text.clear()
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    }

                })
            }
        }

    }
    private fun transitionToResult(result: String, percentage: String) {
        val bundle = Bundle()
        bundle.putString(RESULT, result)
        bundle.putString(PERCENTAGE, percentage)
        findNavController().navigate(R.id.resultFragment, bundle)
    }

    companion object{
        const val RESULT = "result"
        const val PERCENTAGE = "percentage"
    }

}