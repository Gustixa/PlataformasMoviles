package com.samuel.lab_12.logIn

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.samuel.lab_12.R

public class LogInFragmentDirections private constructor() {
  public companion object {
    public fun actionLogInFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_logInFragment_to_homeFragment)
  }
}
