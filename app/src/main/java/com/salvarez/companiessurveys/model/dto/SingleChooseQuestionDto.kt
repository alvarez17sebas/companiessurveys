package com.salvarez.companiessurveys.model.dto

import com.salvarez.companiessurveys.QuestionType


class SingleChooseQuestionDto : QuestionDto() {
    override fun getQuestionType(): Int {
        return QuestionType.SINGLE_CHOOSE_QUESTION
    }
}