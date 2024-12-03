package com.example.ecocontributorapplication.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ecocontributorapplication.R
import com.example.ecocontributorapplication.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Login Button
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                findNavController().navigate(R.id.action_nav_login_to_nav_home)
            } else {
                Snackbar.make(binding.root, "Please enter both email and password", Snackbar.LENGTH_SHORT).show()
            }
        }

        // Sign-Up Button
        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_nav_login_to_nav_signup)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
