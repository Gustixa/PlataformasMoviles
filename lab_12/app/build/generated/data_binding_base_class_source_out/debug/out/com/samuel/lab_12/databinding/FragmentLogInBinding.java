// Generated by view binder compiler. Do not edit!
package com.samuel.lab_12.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import com.samuel.lab_12.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLogInBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonLoginFragmentLogin;

  @NonNull
  public final TextInputLayout inputLayoutLoginFragmentEmail;

  @NonNull
  public final TextInputLayout inputLayoutLoginFragmentPassword;

  @NonNull
  public final ProgressBar progressLogInFragment;

  @NonNull
  public final TextView textLoginFragmentEmail;

  @NonNull
  public final TextView txtLoginFragmentName;

  private FragmentLogInBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button buttonLoginFragmentLogin,
      @NonNull TextInputLayout inputLayoutLoginFragmentEmail,
      @NonNull TextInputLayout inputLayoutLoginFragmentPassword,
      @NonNull ProgressBar progressLogInFragment, @NonNull TextView textLoginFragmentEmail,
      @NonNull TextView txtLoginFragmentName) {
    this.rootView = rootView;
    this.buttonLoginFragmentLogin = buttonLoginFragmentLogin;
    this.inputLayoutLoginFragmentEmail = inputLayoutLoginFragmentEmail;
    this.inputLayoutLoginFragmentPassword = inputLayoutLoginFragmentPassword;
    this.progressLogInFragment = progressLogInFragment;
    this.textLoginFragmentEmail = textLoginFragmentEmail;
    this.txtLoginFragmentName = txtLoginFragmentName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLogInBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLogInBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_log_in, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLogInBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_loginFragment_login;
      Button buttonLoginFragmentLogin = ViewBindings.findChildViewById(rootView, id);
      if (buttonLoginFragmentLogin == null) {
        break missingId;
      }

      id = R.id.inputLayout_loginFragment_email;
      TextInputLayout inputLayoutLoginFragmentEmail = ViewBindings.findChildViewById(rootView, id);
      if (inputLayoutLoginFragmentEmail == null) {
        break missingId;
      }

      id = R.id.inputLayout_loginFragment_password;
      TextInputLayout inputLayoutLoginFragmentPassword = ViewBindings.findChildViewById(rootView, id);
      if (inputLayoutLoginFragmentPassword == null) {
        break missingId;
      }

      id = R.id.progress_logInFragment;
      ProgressBar progressLogInFragment = ViewBindings.findChildViewById(rootView, id);
      if (progressLogInFragment == null) {
        break missingId;
      }

      id = R.id.text_loginFragment_email;
      TextView textLoginFragmentEmail = ViewBindings.findChildViewById(rootView, id);
      if (textLoginFragmentEmail == null) {
        break missingId;
      }

      id = R.id.txt_loginFragment_Name;
      TextView txtLoginFragmentName = ViewBindings.findChildViewById(rootView, id);
      if (txtLoginFragmentName == null) {
        break missingId;
      }

      return new FragmentLogInBinding((ConstraintLayout) rootView, buttonLoginFragmentLogin,
          inputLayoutLoginFragmentEmail, inputLayoutLoginFragmentPassword, progressLogInFragment,
          textLoginFragmentEmail, txtLoginFragmentName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
