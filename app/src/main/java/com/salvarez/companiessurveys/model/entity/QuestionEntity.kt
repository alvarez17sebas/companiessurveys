package com.salvarez.companiessurveys.model.entity

abstract class QuestionEntity() {
    protected lateinit var question: String

    abstract fun getQuestionType(): Int
}