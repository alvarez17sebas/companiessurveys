package com.salvarez.companiessurveys.model.dto

import java.io.Serializable

abstract class QuestionDto {

    var question: String = ""
    var options: MutableList<OptionDto> = ArrayList()

    abstract fun getQuestionType(): Int
}