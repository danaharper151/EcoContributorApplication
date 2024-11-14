package com.example.ecocontributorapplication.ui.logout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ecocontributorapplication.R
import com.example.ecocontributorapplication.databinding.FragmentHomeBinding
import com.example.ecocontributorapplication.ui.home.HomeViewModel

class LogoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val root = inflater.inflate(R.layout.fragment_logout, container, false)

        return root
    }


}