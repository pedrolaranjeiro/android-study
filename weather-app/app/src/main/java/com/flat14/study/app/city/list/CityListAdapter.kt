package com.flat14.study.app.city.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flat14.study.app.R
import com.flat14.study.domain.model.CityWeather
import com.flat14.study.domain.model.getIconUrl
import kotlinx.android.synthetic.main.item_city.view.*

class CityListAdapter(private val cityList: List<CityWeather>) :
    RecyclerView.Adapter<CityListAdapter.ViewHolder>() {

    private val _selectedCity = MutableLiveData<CityWeather>()
    val selectedCity: LiveData<CityWeather> = _selectedCity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cityList[position], _selectedCity)
    }

    override fun getItemCount() = cityList.size

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(weather: CityWeather, _selectedCity: MutableLiveData<CityWeather> ) {
            view.cityName.text = weather.name
            view.weatherDescription.text = weather.description
            view.temperature.text =view.context.getString(R.string.temperature_format, weather.temperature)

            Glide.with(view).load(getIconUrl(weather.icon)).into(view.weatherIcon)
            view.setOnClickListener {
                _selectedCity.value = weather
            }
        }
    }

}