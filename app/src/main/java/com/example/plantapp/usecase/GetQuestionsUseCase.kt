package com.example.plantapp.usecase

import com.example.plantapp.commonlibrary.FlowUseCase
import com.example.plantapp.di.DispatcherModule.IoDispatcher
import com.example.plantapp.model.Question
import com.example.plantapp.model.QuestionsResponse
import com.example.plantapp.repository.remote.question.QuestionRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Use case for fetching a list of questions.
 *
 * This class extends [FlowUseCase] and is responsible for interacting with the
 * [QuestionRepository] to retrieve question data. It emits [GetQuestionsEvent]
 * to indicate the state of the data fetching operation (loading, success, or failure).
 *
 * @param questionRepository The repository responsible for fetching question data.
 * @param dispatcher The coroutine dispatcher to be used for executing the use case,
 *                   typically an I/O dispatcher for network or disk operations.
 */
class GetQuestionsUseCase @Inject constructor(
    private val questionRepository: QuestionRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : FlowUseCase<Unit, GetQuestionsEvent>(dispatcher) {

    override suspend fun getExecutable(params: Unit): Flow<GetQuestionsEvent> = flow {
        emit(GetQuestionsEvent.Loading)
        try {
            val response: QuestionsResponse = questionRepository.getQuestions()
            val questionList = response
            if (questionList.isNotEmpty()) {
                emit(GetQuestionsEvent.Success(questionList))
            } else {
                emit(GetQuestionsEvent.Failure)
            }
        } catch (_: Exception) {
            emit(GetQuestionsEvent.Failure)
        }
    }
}

/**
 * Sealed interface representing the different events that can be emitted by [GetQuestionsUseCase].
 * This allows the UI layer to react to the current state of the data fetching operation.
 */
sealed interface GetQuestionsEvent {

    /**
     * Represents a successful fetch of questions.
     * @param questionList The list of [Question] objects fetched.
     */
    data class Success(
        val questionList: List<Question>
    ) : GetQuestionsEvent

    /**
     * Represents the loading state, indicating that questions are currently being fetched.
     */
    object Loading : GetQuestionsEvent

    /**
     * Represents a failure in fetching questions.
     */
    object Failure : GetQuestionsEvent
}