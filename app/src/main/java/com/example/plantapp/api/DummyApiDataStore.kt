package com.example.plantapp.api

import com.example.plantapp.model.CategoryResponse
import com.example.plantapp.model.QuestionsResponse
import com.example.plantapp.util.ApplicationConstants
import com.example.plantapp.util.ApplicationConstants.API_JSON_UTF_CONTENT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface DummyApiDataStore {

    @Headers(API_JSON_UTF_CONTENT)
    @GET(ApplicationConstants.MergeEndPoint.GET_CATEGORIES)
    suspend fun getCategories(): Response<CategoryResponse>

    @Headers(API_JSON_UTF_CONTENT)
    @GET(ApplicationConstants.MergeEndPoint.GET_QUESTIONS)
    suspend fun getQuestions(): Response<QuestionsResponse>
}