package com.samuel.lab_12.logIn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.samuel.lab_12.viewModel.SessionViewModel
import com.samuel.lab_12.databinding.FragmentLogInBinding
import com.samuel.lab_12.util.visibleIf
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest

class LogInFragment : Fragment() {
    private lateinit var binding: FragmentLogInBinding
    private val sessionViewModel: SessionViewModel by activityViewModels()
    private lateinit var job: Job

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObservables()
        setListeners()
    }

    private fun setListeners() {
        binding.buttonLoginFragmentLogin.setOnClickListener {
            sessionViewModel.login(
                email = binding.inputLayoutLoginFragmentEmail.editText!!.text.toString(),
                password = binding.inputLayoutLoginFragmentPassword.editText!!.text.toString()
            )
        }
    }

    private fun setObservables() {
        job = lifecycleScope.launchWhenStarted {
            sessionViewModel.loginStatus.collectLatest { state ->
                handleLoginState(state)
            }
        }
    }

    private fun handleLoginState(state: SessionViewModel.LoginState) {
        when(state) {
            SessionViewModel.LoginState.Default -> {
                binding.progressLogInFragment.visibleIf(false)
                binding.buttonLoginFragmentLogin.visibleIf(true)
            }
            is SessionViewModel.LoginState.Error -> {
                binding.progressLogInFragment.visibleIf(false)
                binding.buttonLoginFragmentLogin.visibleIf(true)
                Snackbar.make(binding.root, state.message, Snackbar.LENGTH_SHORT).show()
            }
            SessionViewModel.LoginState.Loading -> {
                binding.progressLogInFragment.visibleIf(true)
                binding.buttonLoginFragmentLogin.visibility = View.INVISIBLE
            }
            SessionViewModel.LoginState.Success -> {
                sessionViewModel.generateToken()
                job.cancel()
                requireView().findNavController().navigate(
                    LogInFragmentDirections.actionLogInFragmentToHomeFragment()
                )
            }
        }
    }
}