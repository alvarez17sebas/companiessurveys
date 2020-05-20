package com.salvarez.companiessurveys.model

import com.salvarez.companiessurveys.ContentData
import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.SurveyType

class BuildContentArray {
    companion object{
        fun surveyTypesArray(): Array<ContentData>{
            return arrayOf(ContentData("Encuesta con puntaje", SurveyType.SCORE_SURVEY), ContentData("Encuesta mixta", SurveyType.MIXED_SURVEY))
        }

        fun questionMixedTypesArray(): Array<ContentData>{
            return arrayOf<ContentData>(ContentData("Desplegable", QuestionType.DROP_DOWN_QUESTION),
                ContentData("Selección única", QuestionType.SINGLE_CHOOSE_QUESTION),
                ContentData( "Selección multiple", QuestionType.MULTIPLE_CHOOSE_QUESTION))
        }
    }
}