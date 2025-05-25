package com.example.plantapp.repository.remote.question

import com.example.plantapp.model.QuestionsResponse

interface QuestionRepository {

    suspend fun getQuestions(): QuestionsResponse
}