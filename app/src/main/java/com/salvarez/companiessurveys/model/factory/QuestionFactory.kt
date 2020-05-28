package com.salvarez.companiessurveys.model.factory

import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.model.dto.*

class QuestionFactory {

    companion object{
        fun getQuestion(type: Int?): QuestionDto{
            return when(type){
                QuestionType.DROP_DOWN_QUESTION -> {
                    DropDownQuestionDto()
                }

                QuestionType.SINGLE_CHOOSE_QUESTION -> {
                    SingleChooseQuestionDto()
                }

                QuestionType.MULTIPLE_CHOOSE_QUESTION -> {
                    MultipleChooseQuestionDto()
                }
                else -> {
                    ScoreQuestionDto()
                }
            }
        }
    }
}