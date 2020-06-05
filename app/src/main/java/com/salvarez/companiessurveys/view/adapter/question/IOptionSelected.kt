package com.salvarez.companiessurveys.view.adapter.question

interface IOptionSelected {
    fun optionSelected(questionPosition: Int, optionPosition: Int, questionType: Int)
}