package com.salvarez.companiessurveys.view.adapter.question

import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.model.dto.ScoreQuestionDto

class ScoreQuestionTextChangedImpl(var data: MutableList<QuestionDto>) :
    IScoreQuestionTextChanged {

    override fun textContentChanged(index: Int, text: String) {
        data[index].question = text
    }

    override fun textScoreChanged(index: Int, score: Int) {
        (data[index] as ScoreQuestionDto).score = score
    }
}