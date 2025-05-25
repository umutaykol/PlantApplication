package com.example.plantapp.feature.onboarding.paywall

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.plantapp.databinding.FragmentPaywallBinding
import com.example.plantapp.feature.home.HomeActivity

class PaywallFragment : Fragment() {
    private var _binding: FragmentPaywallBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaywallBinding.inflate(inflater, container, false)
        setClickListeners()
        return binding.root
    }

    fun setClickListeners() {
        binding.closeButton.setOnClickListener {
            startActivity(Intent(requireContext(), HomeActivity::class.java))
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}