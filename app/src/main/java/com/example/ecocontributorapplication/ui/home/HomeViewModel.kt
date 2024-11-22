package com.example.ecocontributorapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecocontributorapplication.Project
import com.example.ecocontributorapplication.SciStarterService
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _projects = MutableLiveData<List<Project>>()
    val projects: LiveData<List<Project>> = _projects

    private val sciStarterService = SciStarterService.create()

    // Fetch projects with the API key passed from the Fragment or Activity
    fun fetchProjects(apiKey: String, queryValue: String) {
        viewModelScope.launch {
            try {
                val response = sciStarterService.getProjects(
                    apiKey = apiKey,
                    value = queryValue // Use queryValue as needed for your API request
                )
                _projects.value = response.projects
            } catch (e: Exception) {
                e.printStackTrace()  // Handle any errors (e.g., network errors)
            }
        }
    }
}
