package com.example.myweatherappcat22.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.example.myweatherappcat22.adapter.ClickedWeather
import com.example.myweatherappcat22.databinding.FragmentFforecastDetailsBinding
import com.example.myweatherappcat22.model.Main


class ForecastDetailsFragment : Fragment() {

    private val binding by lazy {
        FragmentFforecastDetailsBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.Temp.text = "Temp: ${Holder.Temp} C"
        binding.maxTemp.text = "Max Temp: ${Holder.TempMax} C"
        binding.minTemp.text = "Min Temp: ${Holder.TempMin} C"
        binding.Humidity.text = "Humidity: ${Holder.Humid}"

        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ForecastDetailsFragment().apply {

            }
    }



}