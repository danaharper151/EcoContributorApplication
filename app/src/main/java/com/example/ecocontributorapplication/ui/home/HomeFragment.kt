package com.example.ecocontributorapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecocontributorapplication.R
import com.example.ecocontributorapplication.databinding.FragmentHomeBinding
import com.example.ecocontributorapplication.Project
import com.example.ecocontributorapplication.ui.home.ProjectAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var projectAdapter: ProjectAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Initialize RecyclerView adapter
        projectAdapter = ProjectAdapter(emptyList()) { project ->
            // Handle item click (for example, show project details)
        }
        binding.recyclerViewProjects.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = projectAdapter
        }

        // Initialize ViewModel
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        // Fetch projects using API key from strings.xml and a sample query value
        val apiKey = getString(R.string.api_key) // Retrieve the API key
        val queryValue = "yourQueryValue" // Replace with an actual query parameter if needed
        homeViewModel.fetchProjects(apiKey, queryValue)

        // Observe LiveData from ViewModel
        homeViewModel.projects.observe(viewLifecycleOwner) { projects ->
            projectAdapter.updateProjects(projects)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
