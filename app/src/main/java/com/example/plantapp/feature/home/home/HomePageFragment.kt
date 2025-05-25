package com.example.plantapp.feature.home.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.plantapp.feature.home.home.screen.HomePageScreen
import com.example.plantapp.ui.theme.PlantAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment() {

    private val viewModel: HomePageViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            // Collects the state of questions from the ViewModel as a Compose State.
            val questions by viewModel.questions.collectAsState()
            // Collects the state of categories from the ViewModel as a Compose State.
            val categories by viewModel.categories.collectAsState()
            // Collects the loading state for questions from the ViewModel as a Compose State.
            val isQuestionsLoading by viewModel.isQuestionsLoading.collectAsState()
            // Collects the error state for questions from the ViewModel as a Compose State.
            val questionsError by viewModel.questionsError.collectAsState()
            // Collects the loading state for categories from the ViewModel as a Compose State.
            val isCategoriesLoading by viewModel.isCategoriesLoading.collectAsState()
            // Collects the error availability state for categories from the ViewModel as a Compose State.
            val isCategoriesErrorAvailable by viewModel.isCategoriesErrorAvailable.collectAsState()

            PlantAppTheme {
                HomePageScreen(
                    questions = questions,
                    categories = categories,
                    isQuestionsLoading = isQuestionsLoading,
                    questionsError = questionsError,
                    isCategoriesLoading = isCategoriesLoading,
                    isCategoriesErrorAvailable = isCategoriesErrorAvailable == true // Ensures a non-null boolean
                )
            }
        }
    }
}