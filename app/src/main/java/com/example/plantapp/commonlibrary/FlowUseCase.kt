package com.example.plantapp.commonlibrary

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

/**
 * Abstract class representing a use case that returns a Flow of data.
 *
 * @param Params The type of the parameters required to execute the use case.
 * @param Type The type of the data returned by the use case.
 */
abstract class FlowUseCase<in Params, Type>(
    private val dispatcher: CoroutineDispatcher
) {
    /**
     * Abstract method to be implemented by subclasses to provide the executable logic.
     *
     * @param params The parameters required to execute the use case.
     * @return A Flow of the data returned by the use case.
     */
    abstract suspend fun getExecutable(params: Params): Flow<Type>

    suspend operator fun invoke(params: Params): Flow<Type> {
        return withContext(dispatcher) {
            getExecutable(params)
        }
    }
}