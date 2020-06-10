package com.salvarez.companiessurveys.view.adapter.question

import com.salvarez.companiessurveys.model.constant.AdapterEvent
import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.view.adapter.IViewHolderItemSelected

class ViewHolderQuestionSelectedImpl(var data: MutableList<QuestionDto>, var questionAdapter: QuestionAdapter) :
    IViewHolderItemSelected {

    override fun positionSelected(index: Int, event: Int) {
        when (event) {
            AdapterEvent.DELETE_ACTION -> {
                data.removeAt(index)
            }
        }
        questionAdapter.notifyItemRemoved(index)
    }
}