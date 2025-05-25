package com.example.plantapp.repository.remote.question

import com.example.plantapp.api.DummyApiDataStore
import com.example.plantapp.model.QuestionsResponse
import retrofit2.HttpException
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor(
    private val apiDataStore: DummyApiDataStore
) : QuestionRepository {

    override suspend fun getQuestions(): QuestionsResponse {
        val response = apiDataStore.getQuestions()
        val body = response.body()
        body.takeIf { response.isSuccessful }?.let {
            return it
        } ?: throw HttpException(response)
    }
}