package com.salvarez.companiessurveys.model.dto

import com.salvarez.companiessurveys.QuestionType

class MultipleChooseQuestionDto : QuestionDto() {
    override fun getQuestionType(): Int {
        return QuestionType.MULTIPLE_CHOOSE_QUESTION
    }
}