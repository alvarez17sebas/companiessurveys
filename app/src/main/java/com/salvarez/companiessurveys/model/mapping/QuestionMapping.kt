package com.salvarez.companiessurveys.model.mapping

import com.google.gson.Gson
import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.model.dto.SurveyDto
import com.salvarez.companiessurveys.model.entity.QuestionEntity
import com.salvarez.companiessurveys.model.entity.SurveyEntity

class QuestionMapping {

    companion object {


        fun surveyDtoToSurveyEntity(surveyDto: SurveyDto): SurveyEntity{
            var gson = Gson()
            var strJson = gson.toJson(surveyDto)
            return gson.fromJson(strJson, SurveyEntity::class.java)
        }

        fun surveyentityToSurveyDto(surveyEntity: SurveyEntity): SurveyDto{
            var gson = Gson()
            var strJson = gson.toJson(surveyEntity)
            return gson.fromJson(strJson, SurveyDto::class.java)
        }

        fun questionDtoToQuestionEntity(questionDto: QuestionDto): QuestionEntity {
            var gson = Gson()
            var strJson = gson.toJson(questionDto)
            return gson.fromJson(strJson, QuestionEntity::class.java)
        }

        fun questionEntityToQuestionDto(questionEntity: QuestionEntity): QuestionDto {
            var gson: Gson = Gson()
            var strJson = gson.toJson(questionEntity)
            return gson.fromJson(strJson, QuestionDto::class.java)
        }
    }

}