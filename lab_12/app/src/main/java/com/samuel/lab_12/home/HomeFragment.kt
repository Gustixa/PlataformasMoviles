package com.samuel.lab_12.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.samuel.lab_12.R
import com.samuel.lab_12.viewModel.SessionViewModel
import com.samuel.lab_12.databinding.FragmentHomeBinding
import com.samuel.lab_12.util.visibleIf
import kotlinx.coroutines.flow.collectLatest

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val sessionViewModel: SessionViewModel by activityViewModels()
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObservables()
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            btnHomeFragmentDefault.setOnClickListener {
                homeViewModel.changeState(HomeViewModel.HomeViewState.Default)
            }

            btnHomeFragmentSuccess.setOnClickListener {
                homeViewModel.changeState(HomeViewModel.HomeViewState.Success)
            }

            btnHomeFragmentFailure.setOnClickListener {
                homeViewModel.changeState(HomeViewModel.HomeViewState.Failure)
            }

            btnHomeFragmentEmpty.setOnClickListener {
                homeViewModel.changeState(HomeViewModel.HomeViewState.Empty)
            }

            btnHomeFragmentKeepSession.setOnClickListener {
                sessionViewModel.cancelJob()
            }

            btnHomeFragmentLogOut.setOnClickListener {
                sessionViewModel.logOut()
            }
        }
    }

    private fun setObservables() {
        lifecycleScope.launchWhenStarted {
            sessionViewModel.validAuthToken.collectLatest { isValid ->
                if (!isValid) {
                    Toast.makeText(requireContext(), "logout", Toast.LENGTH_SHORT).show()
                    requireActivity().onBackPressed()
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            homeViewModel.homeState.collectLatest { state ->
                handleHomeState(state)
            }
        }

    }

    private fun handleHomeState(state: HomeViewModel.HomeViewState) {
        when(state) {
            HomeViewModel.HomeViewState.Default -> {
                setStateLoading(false)
                enableButtons()
                binding.iconHomeFragmentStatus.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_fort)
                )
                binding.textHomeFragmentDescription.text = "Selecciona una opción"
            }

            HomeViewModel.HomeViewState.Empty -> {
                setStateLoading(false)
                enableButtons()
                binding.iconHomeFragmentStatus.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_do_not_disturb)
                )
                binding.textHomeFragmentDescription.text = "Sin resultados"
            }

            HomeViewModel.HomeViewState.Failure -> {
                setStateLoading(false)
                enableButtons()
                binding.iconHomeFragmentStatus.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_error)
                )
                binding.textHomeFragmentDescription.text = "¡Operación fallida!"
            }

            HomeViewModel.HomeViewState.Success -> {
                setStateLoading(false)
                enableButtons()
                binding.iconHomeFragmentStatus.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_check_circle)
                )
                binding.textHomeFragmentDescription.text = "¡Operación exitosa!"
            }

            is HomeViewModel.HomeViewState.Loading -> {
                setStateLoading(true)
                binding.btnHomeFragmentDefault.isEnabled = state.currentState == HomeViewModel.HomeViewState.Default
                binding.btnHomeFragmentSuccess.isEnabled = state.currentState == HomeViewModel.HomeViewState.Success
                binding.btnHomeFragmentFailure.isEnabled = state.currentState == HomeViewModel.HomeViewState.Failure
                binding.btnHomeFragmentEmpty.isEnabled = state.currentState == HomeViewModel.HomeViewState.Empty
            }
        }
    }

    private fun setStateLoading(isLoading: Boolean) {
        binding.progressHomeFragment.visibleIf(isLoading)
        binding.iconHomeFragmentStatus.visibleIf(!isLoading)
        binding.textHomeFragmentDescription.visibleIf(!isLoading)
    }

    private fun enableButtons() {
        binding.btnHomeFragmentDefault.isEnabled = true
        binding.btnHomeFragmentEmpty.isEnabled = true
        binding.btnHomeFragmentFailure.isEnabled = true
        binding.btnHomeFragmentSuccess.isEnabled = true
    }

}