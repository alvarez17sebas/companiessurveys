package com.salvarez.companiessurveys.viewmodel

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.salvarez.companiessurveys.model.dto.ScoreQuestionDto
import com.salvarez.companiessurveys.model.factory.QuestionFactory

class CreateScoreQuestionViewModel : ViewModel() {

    fun getEmptyScoreQuestion(type: Int): ScoreQuestionDto{
        return QuestionFactory.getQuestion(type) as ScoreQuestionDto
    }

    fun getStrScoreQuestions(scoreQuestionList: MutableList<ScoreQuestionDto>): String{
        return Gson().toJson(scoreQuestionList)
    }
}