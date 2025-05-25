package com.example.plantapp.feature.onboarding.getstarted

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.plantapp.R
import com.example.plantapp.databinding.FragmentGetStartedBinding

class GetStartedFragment : Fragment() {

    private var _binding: FragmentGetStartedBinding? = null
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGetStartedBinding.inflate(inflater, container, false)
        val text = getString(R.string.get_started_by_tapping)
        binding.textByTapping.text = Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY)

        binding.buttonGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_getStarted_to_onboardingOne)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}