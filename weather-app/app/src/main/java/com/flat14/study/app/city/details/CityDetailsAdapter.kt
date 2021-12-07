package com.flat14.study.app.city.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flat14.study.app.R
import com.flat14.study.domain.model.Forecast
import com.flat14.study.domain.model.getIconUrl
import kotlinx.android.synthetic.main.item_city_details.view.temperature
import kotlinx.android.synthetic.main.item_city_details.view.weatherDescription
import kotlinx.android.synthetic.main.item_city_details.view.weatherIcon
import kotlinx.android.synthetic.main.item_city_details.view.*

class CityDetailsAdapter(
    private val forecast: MutableList<Forecast>
) : RecyclerView.Adapter<CityDetailsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city_details, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(forecast[position])
    }

    override fun getItemCount() = forecast.size

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(forecast: Forecast) {
            view.weatherDescription.text = forecast.description
            view.temperature.text =
                view.context.getString(R.string.temperature_format, forecast.temperature)
            view.date.text = forecast.date
            Glide.with(view).load(getIconUrl(forecast.icon)).into(view.weatherIcon)
        }
    }

}