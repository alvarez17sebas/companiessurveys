package com.salvarez.companiessurveys.model.dto

import com.salvarez.companiessurveys.QuestionType

class ScoreQuestionDto : QuestionDto() {

    var score: Int = 0

    override fun getQuestionType(): Int {
        return QuestionType.SCORE_QUESTION
    }
}