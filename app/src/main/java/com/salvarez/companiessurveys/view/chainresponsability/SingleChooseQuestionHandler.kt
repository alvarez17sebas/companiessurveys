package com.salvarez.companiessurveys.view.chainresponsability

import android.view.View
import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.view.adapter.question.IMixedOptionSelected

class SingleChooseQuestionHandler(nextViewHolderHandler: ViewHolderHandler, itemView: View, var mixedOptionSelected: IMixedOptionSelected) : ViewHolderHandler() {

    init {
        this.nextViewHolderHandler = nextViewHolderHandler
    }

    override fun drawContent(typeQuestion: Int) {
        if (typeQuestion == QuestionType.SINGLE_CHOOSE_QUESTION){

        }else{
            nextViewHolderHandler.drawContent(typeQuestion)
        }
    }
}