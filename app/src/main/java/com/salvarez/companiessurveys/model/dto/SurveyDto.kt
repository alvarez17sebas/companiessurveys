package com.salvarez.companiessurveys.model.dto

class SurveyDto(var surveyName: String,
                var description: String,
                var surveyType: Int,
                var dateSurvey: String,
                var enabled: Boolean,
                var questionList: MutableList<QuestionDto>) {
}