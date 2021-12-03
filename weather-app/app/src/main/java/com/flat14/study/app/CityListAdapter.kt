package com.flat14.study.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flat14.study.domain.model.CityWeather
import kotlinx.android.synthetic.main.item_city.view.*

class CityListAdapter(private val cityList: List<CityWeather>) :
    RecyclerView.Adapter<CityListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(cityList[position])
    }

    override fun getItemCount() = cityList.size


    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(cityWeather: CityWeather) {
            view.cityName.text = cityWeather.name
            view.weatherDescription.text = cityWeather.description
            view.min.text = view.context.getString(R.string.temperature_format, cityWeather.min)
            view.max.text = view.context.getString(R.string.temperature_format, cityWeather.max)
            view.weatherIcon.text = cityWeather.icon
            view.temperature.text =view.context.getString(R.string.temperature_format, cityWeather.temperature)
            view.feelsTemperature.text = view.context.getString(R.string.temperature_format, cityWeather.feelsLike)
            view.humidity.text = view.context.getString(R.string.humidity_format, cityWeather.humidity)
            view.weather.text = cityWeather.weather
        }
    }

}