package com.flat14.study.app.city.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.flat14.study.app.MainViewModel
import com.flat14.study.app.R
import com.flat14.study.app.databinding.FragmentCityAddBinding
import org.koin.androidx.navigation.koinNavGraphViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CityAddFragment : Fragment() {

    private val model: CityAddViewModel by koinNavGraphViewModel(R.id.nav_graph)
    private val mainActivityModel: MainViewModel by sharedViewModel ()

    private var _binding: FragmentCityAddBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCityAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAdd.setOnClickListener {
            model.addCity(binding.city.text.toString())
            findNavController().navigate(R.id.CityListFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        mainActivityModel.showFAB(false)
    }


    override fun onPause() {
        super.onPause()
        mainActivityModel.showFAB(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}