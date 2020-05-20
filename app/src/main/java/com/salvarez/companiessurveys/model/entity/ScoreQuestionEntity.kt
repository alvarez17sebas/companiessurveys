package com.salvarez.companiessurveys.model.entity

import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.model.entity.QuestionEntity

class ScoreQuestionEntity(var score: Int) : QuestionEntity() {

    override fun getQuestionType(): Int {
        return QuestionType.SCORE_QUESTION
    }

}