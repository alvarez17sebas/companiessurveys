package com.salvarez.companiessurveys.view.adapter.question

interface IScoreQuestionTextChanged {
    fun textContentChanged(index: Int ,text: String)
    fun textScoreChanged(index: Int ,score: Int)
}