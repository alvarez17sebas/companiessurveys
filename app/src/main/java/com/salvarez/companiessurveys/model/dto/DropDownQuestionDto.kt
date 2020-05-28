package com.salvarez.companiessurveys.model.dto

import com.salvarez.companiessurveys.QuestionType
import java.io.Serializable

class DropDownQuestionDto : QuestionDto(){

    override fun getQuestionType(): Int {
        return QuestionType.DROP_DOWN_QUESTION
    }
}