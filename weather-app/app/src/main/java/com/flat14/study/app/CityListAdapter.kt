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
            view.min.text = cityWeather.min.toString()
            view.max.text = cityWeather.max.toString()
            view.weatherIcon.text = cityWeather.icon
            view.temperature.text = cityWeather.temperature.toString()
            view.feelsTemperature.text = cityWeather.feelsLike.toString()
            view.humidity.text = cityWeather.humidity.toString()
            view.weather.text = cityWeather.weather
        }
    }

}