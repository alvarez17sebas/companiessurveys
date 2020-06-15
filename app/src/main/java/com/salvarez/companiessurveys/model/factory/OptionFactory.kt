package com.salvarez.companiessurveys.model.factory

import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.model.dto.ScoreOptionDto

class OptionFactory {
    companion object{
        fun getOption(type: Int): OptionDto{
            return if(type == QuestionType.SCORE_QUESTION){
                ScoreOptionDto()
            }else{
                OptionDto()
            }
        }
    }
}