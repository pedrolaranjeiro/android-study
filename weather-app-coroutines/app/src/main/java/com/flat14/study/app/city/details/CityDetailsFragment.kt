package com.flat14.study.app.city.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.flat14.study.app.R
import com.flat14.study.app.databinding.FragmentCityDetailBinding
import com.flat14.study.domain.model.Forecast
import kotlinx.android.synthetic.main.fragment_city_detail.*
import org.koin.androidx.navigation.koinNavGraphViewModel

const val KEY_CITY_NAME = "cityName"
/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CityDetailsFragment : Fragment() {

    private val model: CityDetailsViewModel by koinNavGraphViewModel(R.id.nav_graph)
    private var _binding: FragmentCityDetailBinding? = null
    private val forecast = mutableListOf<Forecast>()
    private val adapter = CityDetailsAdapter(forecast)

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model.cityWeatherForecast.observe(this, Observer {
            binding.cityName.text = it.name
            forecast.clear()
            forecast.addAll(it.forecast)
            adapter.notifyDataSetChanged()
        })
        arguments?.getString(KEY_CITY_NAME)?.let {
            model.getWeatherForecast(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCityDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailsRecyclerView.adapter =  adapter
        detailsRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}