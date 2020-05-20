package com.salvarez.companiessurveys.model.entity

import com.salvarez.companiessurveys.QuestionType

class DropDownQuestionEntity : QuestionEntity() {

    override fun getQuestionType(): Int {
        return QuestionType.DROP_DOWN_QUESTION
    }
}
