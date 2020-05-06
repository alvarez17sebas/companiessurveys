package com.salvarez.companiessurveys.model.domain

import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.model.entity.QuestionScoreEntity

class SurveyDomain(var questionList: MutableList<QuestionDto>) {

    fun getTotalQuestionScore() : Int{
        var totalScore: Int = 0
        questionList.forEach {
            val questionScore = it as QuestionScoreEntity
            totalScore =+ questionScore.score
        }
        return totalScore
    }
}