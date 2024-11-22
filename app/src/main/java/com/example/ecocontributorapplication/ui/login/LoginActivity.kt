package com.example.ecocontributorapplication.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.ecocontributorapplication.R
import com.example.ecocontributorapplication.ui.home.HomeViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize ViewModel
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        // Fetch projects using API key and a sample query value
        val apiKey = getString(R.string.api_key) // Retrieve the API key
        val queryValue = "yourQueryValue" // Replace with the actual query parameter if needed
        homeViewModel.fetchProjects(apiKey, queryValue)

        // You can observe ViewModel here if necessary for login-related tasks
        homeViewModel.projects.observe(this) { projects ->
            // Handle projects, e.g., display them after successful login
        }
    }
}
