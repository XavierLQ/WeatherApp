package com.example.myweatherappcat22.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myweatherappcat22.adapter.ClickedWeather
import com.example.myweatherappcat22.adapter.WeatherAdapter
import com.example.myweatherappcat22.databinding.FragmentForecastBinding
import com.example.myweatherappcat22.model.Main

import com.example.myweatherappcat22.viewmodel.ResultState

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ForecastFragment : BaseFragment(), ClickedWeather  {
    private var param1: String? = null
    private var param2: String? = null

    private val binding by lazy {
        FragmentForecastBinding.inflate(layoutInflater)
    }

    private val weatherAdapter by lazy {

        WeatherAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment




        binding.forecastRV.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )

            adapter = weatherAdapter
        }

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            val city = bundle.getString("bundleKey")
            if (city != null) {

                weatherViewModel.cityForecast.observe(viewLifecycleOwner, ::handleState)
                weatherViewModel.getForecast(city)

            }
        }


        return binding.root
    }

    private fun handleState(resultState: ResultState) {
        when(resultState) {
            is ResultState.LOADING -> {

                binding.progressBar.visibility = View.VISIBLE
                Toast.makeText(requireContext(), "LOADING...", Toast.LENGTH_LONG).show()
            }
            is ResultState.SUCCESS -> {
                weatherAdapter.setForecast(resultState.results.list)
                binding.progressBar.visibility = View.GONE
            }
            is ResultState.ERROR -> {
                binding.progressBar.visibility = View.GONE
                Log.e("FORECAST", resultState.error.localizedMessage, resultState.error)
                Toast.makeText(requireContext(), resultState.error.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun OnClickedWeather(main: Main) {

        Holder.Temp = convertKtoC(main.temp).toString()
        Holder.TempMax = convertKtoC(main.tempMax).toString()
        Holder.TempMin = convertKtoC(main.tempMin).toString()
        Holder.Humid = main.humidity.toString()
    }
}

// let avoid this using these singletons, you can get the same behavior using the view model
// passing the data between fragments
object Holder{

    var Temp: String? = null
    var TempMax: String? = null
    var TempMin: String? = null
    var Humid: String? = null
}