package com.example.lab_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavArgs
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var buttonUpdateProfile: Button
    private lateinit var txtHome: TextView
    private val argsLogIn: HomeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonUpdateProfile = view.findViewById(R.id.button_fragmentHome_updateProfile)
        txtHome = view.findViewById(R.id.txtView_fragmentHome_emailUser)

        txtHome.text = argsLogIn.email
        setListeners()
    }

    private fun setListeners() {
        buttonUpdateProfile.setOnClickListener {
            requireView().findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }
    }
}
