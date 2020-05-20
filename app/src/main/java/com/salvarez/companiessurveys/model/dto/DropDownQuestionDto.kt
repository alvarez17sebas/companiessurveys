package com.salvarez.companiessurveys.model.dto

import com.salvarez.companiessurveys.QuestionType

class DropDownQuestionDto : QuestionDto(){

    override fun getQuestionType(): Int {
        return QuestionType.DROP_DOWN_QUESTION
    }
}