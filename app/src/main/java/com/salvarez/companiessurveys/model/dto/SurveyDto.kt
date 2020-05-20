package com.salvarez.companiessurveys.model.dto

class SurveyDto(var surveyType: Int,
                var dateSurvey: String,
                var enabled: Boolean,
                var questionList: MutableList<QuestionDto>) {
}