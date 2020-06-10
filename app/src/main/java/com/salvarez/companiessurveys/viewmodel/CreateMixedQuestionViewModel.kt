package com.salvarez.companiessurveys.viewmodel

import androidx.lifecycle.ViewModel
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.model.factory.OptionFactory
import com.salvarez.companiessurveys.model.factory.QuestionFactory

class CreateMixedQuestionViewModel : ViewModel() {

    fun getFillQuestionDto(questionType: Int, questionParam: String, options:MutableList<OptionDto>): QuestionDto{

        var question = QuestionFactory.getQuestion(questionType)
        question.question = questionParam
        question.options = options

        return question
    }

    fun getEmptyQuestionDto(type: Int): OptionDto{
        return OptionFactory.getOption(type)
    }
}