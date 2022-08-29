package com.example.lab_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var buttonLogIn:Button
    private lateinit var buttonNewAccount: Button
    private lateinit var inputLayoutEmail: TextInputLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogIn = view.findViewById(R.id.button_fragmentLogIn_startSession)
        buttonNewAccount = view.findViewById(R.id.btn_fragmentLogIn_newAccount)
        inputLayoutEmail = view.findViewById(R.id.txtInputLayout_fragmentLogin_emailInput)

        setListeners()
    }

    private fun setListeners(){

        buttonLogIn.setOnClickListener{
            val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(
                email = inputLayoutEmail.editText!!.text.toString()
            )
            requireView().findNavController().navigate(action)
        }

        buttonNewAccount.setOnClickListener{
            requireView().findNavController().navigate(R.id.action_loginFragment_to_newAccountFragment)
        }
    }
}