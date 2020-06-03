package com.example.covid_19.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.covid_19.R
import com.example.covid_19.databinding.FragmentRealtimeDataBinding
import com.example.covid_19.network.ApiClient
import com.example.covid_19.pojo.CovidData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


/**
 * Class [Fragment] used to show COVID-19 cases data fetched from network
 */
class RealtimeDataFragment : Fragment() {
    /**
     * Object used for data binding
     */
    private lateinit var binding: FragmentRealtimeDataBinding

    private lateinit var context: AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = activity as AppCompatActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentRealtimeDataBinding>(
            inflater, R.layout.fragment_realtime_data, container, false
        )
        binding.progressCircular.visibility = View.VISIBLE
        binding.progressCircular.bringToFront()
        binding.root.requestLayout()
        binding.root.invalidate()

        // Set the onClickListener for the submitButton
        binding.ivInformation.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            view.findNavController()
                .navigate(R.id.action_realtimeDataFragment_to_informationDataFragment)

        }

        binding.efabDonateToHelp.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_realtimeDataFragment_to_loginFragment)
        }
        getData()
        return binding.root
    }

    /**
     * Method used to fetch COVID-19 data from network
     */
    private fun getData() {
        val call: Call<CovidData> = ApiClient.getClient.getCovidData()
        call.enqueue(object : Callback<CovidData> {
            override fun onFailure(call: Call<CovidData>, t: Throwable) {
                println("data received failure")
                binding.progressCircular.visibility = View.GONE
            }

            override fun onResponse(
                call: Call<CovidData>,
                response: Response<CovidData>
            ) {
                val covidData: CovidData = response.body()!!
                covidData.updated = getDate(
                    covidData.updated?.toLong(),
                    "dd MMM, yyyy hh:mm:ss"
                )
                binding.coviddata = covidData
                binding.invalidateAll()
                println(
                    "data received success"
                )
                binding.progressCircular.visibility = View.GONE

            }

        })
    }

    private fun getDate(milliseconds: Long?, dateFormat: String): String {
        val formatter = SimpleDateFormat(dateFormat, Locale.ENGLISH)
        val calendar = Calendar.getInstance()
        if (milliseconds != null) {
            calendar.timeInMillis = milliseconds
        }
        return formatter.format(calendar.time)
    }
}
