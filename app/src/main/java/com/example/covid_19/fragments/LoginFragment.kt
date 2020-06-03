package com.example.covid_19.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.covid_19.R
import com.example.covid_19.databinding.FragmentLoginBinding

/**
 * Class [Fragment] used to ask user to login
 */
class LoginFragment : Fragment() {
    /**
     * Object used for data binding
     */
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )
        binding.efabProceedToDonate.setOnClickListener {
            showAlertDialog("DONATE TO HELP", "Coming Soon!!")
        }
        return binding.root
    }

    /**
     * Method used to show alert dialog
     * @param title - Title for dialog
     * @param message - Message for dialog
     */
    private fun showAlertDialog(title: String, message: String) {

        val builder = activity?.let { AlertDialog.Builder(it) }
        with(builder)
        {
            this?.setTitle(title)
            this?.setMessage(message)
            this?.setPositiveButton(android.R.string.yes) { _, _ ->

            }
            this?.show()
        }
    }

}
