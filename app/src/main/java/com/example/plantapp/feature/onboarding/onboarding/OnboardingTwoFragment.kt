package com.example.plantapp.feature.onboarding.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.plantapp.R
import com.example.plantapp.databinding.FragmentOnboardingTwoBinding

class OnboardingTwoFragment : Fragment() {
    private var _binding: FragmentOnboardingTwoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingTwoBinding.inflate(inflater, container, false)
        binding.buttonContinue.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingTwo_to_paywall)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}