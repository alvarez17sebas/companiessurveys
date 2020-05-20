package com.salvarez.companiessurveys.model.entity

class SurveyEntity(var surveyType: Int,
                   var dateSurvey: String,
                   var enabled: Boolean,
                   var questionList: MutableList<QuestionEntity>) {
}