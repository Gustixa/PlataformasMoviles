package com.samuel.lab_12.viewModel.scope

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.samuel.lab_12.R
import com.google.android.material.textfield.TextInputLayout
import com.samuel.lab_12.databinding.FragmentLogInBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLogInBinding

    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var buttonLogin: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        checkIsLogged()
        setListeners()
    }

    private fun setListeners() {
        TODO("Not yet implemented")
    }


//    private fun checkIsLogged() {
//        CoroutineScope(Dispatchers.IO).launch {
//            val currentUser = requireContext().dataStore.getPreferencesValue(KEY_MAIL)
//            if (currentUser != null) {
//                navigateToListScreen()
//            }
//        }
//    }

//    private fun setListeners() {
//        buttonLogin.setOnClickListener {
//            loginUser(
//                email = inputEmail.editText!!.text.toString(),
//                password = inputPassword.editText!!.text.toString()
//            )
//        }
//    }
//
//    private fun loginUser(email: String, password: String) {
//        if ((email == getString(R.string.my_email)) && email == password) {
//            saveLoggedUser(email)
//        } else {
//            Toast.makeText(requireContext(), getString(R.string.error_email_password), Toast.LENGTH_LONG).show()
//        }
//    }
//
//    private fun navigateToListScreen() {
//        CoroutineScope(Dispatchers.Main).launch {
//            requireView().findNavController().navigate(
//                LoginFragmentDirections.actionLoginFragmentToCharacterListFragment()
//            )
//        }
//    }
//
////    private fun saveLoggedUser(email: String) {
////        CoroutineScope(Dispatchers.IO).launch {
////            requireContext().dataStore.savePreferencesValue(KEY_MAIL, email)
////            navigateToListScreen()
////        }
////    }
}