package com.example.plantapp.feature.home.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantapp.model.CategoryData
import com.example.plantapp.model.Question
import com.example.plantapp.usecase.GetCategoriesEvent
import com.example.plantapp.usecase.GetCategoriesUseCase
import com.example.plantapp.usecase.GetQuestionsEvent
import com.example.plantapp.usecase.GetQuestionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the Home Page.
 *
 * This ViewModel is responsible for fetching and managing the data related to questions and categories
 * that are displayed on the home screen. It uses Hilt for dependency injection.
 *
 * @param getQuestionsUseCase Use case for fetching questions.
 * @param getCategoriesUseCase Use case for fetching categories.
 */
@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val getQuestionsUseCase: GetQuestionsUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    // StateFlow for the list of questions.
    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> = _questions.asStateFlow()

    // StateFlow for the list of categories.
    private val _categories = MutableStateFlow<List<CategoryData>>(emptyList())
    val categories: StateFlow<List<CategoryData>> = _categories.asStateFlow()

    // StateFlow to indicate if questions are currently being loaded.
    private val _isQuestionsLoading = MutableStateFlow(false)
    val isQuestionsLoading: StateFlow<Boolean> = _isQuestionsLoading.asStateFlow()

    // StateFlow to hold any error message related to fetching questions.
    private val _questionsError = MutableStateFlow<String?>(null)
    val questionsError: StateFlow<String?> = _questionsError.asStateFlow()

    // StateFlow to indicate if categories are currently being loaded.
    private val _isCategoriesLoading = MutableStateFlow(false)
    val isCategoriesLoading: StateFlow<Boolean> = _isCategoriesLoading.asStateFlow()

    // StateFlow to indicate if an error occurred while fetching categories.
    private val _isCategoriesErrorAvailable = MutableStateFlow<Boolean?>(false)
    val isCategoriesErrorAvailable: StateFlow<Boolean?> = _isCategoriesErrorAvailable.asStateFlow()

    init {
        // Fetch questions and categories when the ViewModel is initialized.
        getQuestions()
        getCategories()
    }

    /**
     * Fetches the list of categories.
     *
     * This function launches a coroutine in the viewModelScope to call the [getCategoriesUseCase].
     * It updates the relevant StateFlows based on the [GetCategoriesEvent] received.
     */
    private fun getCategories() = viewModelScope.launch {
        getCategoriesUseCase(Unit).collect { event ->
            when (event) {
                GetCategoriesEvent.Failure -> {
                    _isCategoriesLoading.value = false
                    _isCategoriesErrorAvailable.value = true
                }
                GetCategoriesEvent.Loading -> {
                    _isCategoriesLoading.value = true
                    _isCategoriesErrorAvailable.value = null // Reset error state on loading
                }
                is GetCategoriesEvent.Success -> {
                    _isCategoriesLoading.value = false
                    _isCategoriesErrorAvailable.value = null // Reset error state on success
                    _categories.value = event.categoryList
                }
            }
        }
    }

    /**
     * Fetches the list of questions.
     *
     * This function launches a coroutine in the viewModelScope to call the [getQuestionsUseCase].
     * It updates the relevant StateFlows based on the [GetQuestionsEvent] received.
     */
    private fun getQuestions() = viewModelScope.launch {
        getQuestionsUseCase.getExecutable(Unit).collect { event ->
            when (event) {
                GetQuestionsEvent.Failure -> {
                    _isQuestionsLoading.value = false
                    _questionsError.value = "Failed to load questions"
                }
                GetQuestionsEvent.Loading -> {
                    _isQuestionsLoading.value = true
                    _questionsError.value = null // Reset error state on loading
                }
                is GetQuestionsEvent.Success -> {
                    _isQuestionsLoading.value = false
                    _questionsError.value = null // Reset error state on success
                    _questions.value = event.questionList
                }
            }
        }
    }
}