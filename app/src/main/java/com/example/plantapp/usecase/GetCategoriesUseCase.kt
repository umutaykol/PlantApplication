package com.example.plantapp.usecase

import com.example.plantapp.commonlibrary.FlowUseCase
import com.example.plantapp.di.DispatcherModule.IoDispatcher
import com.example.plantapp.model.CategoryData
import com.example.plantapp.model.CategoryResponse
import com.example.plantapp.repository.remote.category.CategoryRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Use case for fetching a list of categories.
 *
 * This class extends [FlowUseCase] and is responsible for interacting with the
 * [CategoryRepository] to retrieve category data. It emits [GetCategoriesEvent]
 * to indicate the state of the data fetching operation (loading, success, or failure).
 *
 * @param categoryRepository The repository responsible for fetching category data.
 * @param dispatcher The coroutine dispatcher to be used for executing the use case,
 *                   typically an I/O dispatcher for network or disk operations.
 */
class GetCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : FlowUseCase<Unit, GetCategoriesEvent>(dispatcher) {

    override suspend fun getExecutable(params: Unit): Flow<GetCategoriesEvent> = flow {
        emit(GetCategoriesEvent.Loading)
        try {
            val response: CategoryResponse = categoryRepository.getCategories()
            val categories: List<CategoryData> = response.data ?: emptyList()
            if (categories.isNotEmpty()) {
                emit(GetCategoriesEvent.Success(categories))
            } else {
                emit(GetCategoriesEvent.Failure)
            }
        } catch (_: Exception) {
            emit(GetCategoriesEvent.Failure)
        }
    }
}

/**
 * Sealed interface representing the different events that can be emitted by [GetCategoriesUseCase].
 * This allows the UI layer to react to the current state of the data fetching operation.
 */
sealed interface GetCategoriesEvent {
    /**
     * Represents a successful fetch of categories.
     * @param categoryList The list of [CategoryData] objects fetched.
     */
    data class Success(val categoryList: List<CategoryData>) : GetCategoriesEvent

    /**
     * Represents the loading state, indicating that categories are currently being fetched.
     */
    object Loading : GetCategoriesEvent

    /**
     * Represents a failure in fetching categories.
     */
    object Failure : GetCategoriesEvent
}