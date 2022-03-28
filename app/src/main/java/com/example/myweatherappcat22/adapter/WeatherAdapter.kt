package com.example.myweatherappcat22.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myweatherappcat22.R
import com.example.myweatherappcat22.databinding.ForcastItemBinding
import com.example.myweatherappcat22.model.Forecast
import com.example.myweatherappcat22.model.Main
import com.example.myweatherappcat22.views.convertKtoC
import com.example.myweatherappcat22.views.convertPaToPSI

class WeatherAdapter(
        private val clickedWeather: ClickedWeather
) : RecyclerView.Adapter<ForecastViewHolder>() {

    private val forecastList: MutableList<Forecast> = mutableListOf()

    fun setForecast(newForecast: List<Forecast>) {
        forecastList.clear()
        forecastList.addAll(newForecast)
        notifyItemRangeChanged(0, itemCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = ForcastItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ForecastViewHolder(view, clickedWeather)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) =
        holder.bind(forecastList[position].main, forecastList[position].dtTxt)

    override fun getItemCount(): Int = forecastList.size
}

class ForecastViewHolder(private val binding: ForcastItemBinding, private val clickedWeather:ClickedWeather) : RecyclerView.ViewHolder(binding.root) {

    fun bind(main: Main, date: String) {
        binding.weatherDate.text=date
        binding.weatherTemp.text = "Temp: ${convertKtoC(main.temp)} C"
        binding.weatherPressure.text = "Pressure: ${main.pressure.convertPaToPSI()} psi"
        binding.mRating.setProgress(2)

        itemView.setOnClickListener{ view ->
            view.findNavController()
                .navigate(R.id.action_ForecastFragment_to_DetailsFragment)

            clickedWeather.OnClickedWeather(main)

        }

    }

}