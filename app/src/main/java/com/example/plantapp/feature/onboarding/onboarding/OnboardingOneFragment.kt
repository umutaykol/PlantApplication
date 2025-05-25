package com.example.plantapp.feature.onboarding.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.plantapp.R
import com.example.plantapp.databinding.FragmentOnboardingOneBinding

class OnboardingOneFragment : Fragment() {
    private var _binding: FragmentOnboardingOneBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingOneBinding.inflate(inflater, container, false)
        setOnClickListeners()
        return binding.root
    }

    fun setOnClickListeners() {
        binding.buttonContinue.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingOne_to_onboardingTwo)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}