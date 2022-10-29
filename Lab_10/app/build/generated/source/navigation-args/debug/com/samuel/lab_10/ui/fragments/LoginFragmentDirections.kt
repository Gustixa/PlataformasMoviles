package com.samuel.lab_10.ui.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.samuel.lab_10.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginFragmentToCharacterListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_characterListFragment)
  }
}
