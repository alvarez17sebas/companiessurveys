package com.salvarez.companiessurveys.view.adapter.question

interface IMixedOptionSelected {
    fun optionSelected(questionPosition: Int, optionPosition: Int, questionType: Int)
}