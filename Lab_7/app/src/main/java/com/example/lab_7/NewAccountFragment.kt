package com.example.lab_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [NewAccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewAccountFragment : Fragment(R.layout.fragment_new_account) {
    private lateinit var btnNewEmail: Button
    private lateinit var inputLayoutEmail: TextInputLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnNewEmail = view.findViewById(R.id.btn_fragmentNewAccount_createAccount)
        inputLayoutEmail = view.findViewById(R.id.txtInputLayout_fragmentNewAccount)

        setListeners()
    }

    private fun setListeners(){
        btnNewEmail.setOnClickListener{
            val action = NewAccountFragmentDirections.actionNewAccountFragmentToHomeFragment(
                email = inputLayoutEmail.editText!!.text.toString()
            )
            requireView().findNavController().navigate(action)
        }
    }
}