package com.samuel.lab_10.ui.fragments

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.samuel.lab_10.R
import kotlin.Int

public class CharacterListFragmentDirections private constructor() {
  private data class ActionCharacterListFragmentToCharacterDetailsFragment(
    public val id: Int
  ) : NavDirections {
    public override val actionId: Int =
        R.id.action_characterListFragment_to_characterDetailsFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("id", this.id)
        return result
      }
  }

  public companion object {
    public fun actionCharacterListFragmentToCharacterDetailsFragment(id: Int): NavDirections =
        ActionCharacterListFragmentToCharacterDetailsFragment(id)

    public fun actionCharacterListFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_characterListFragment_to_loginFragment)
  }
}
