package com.salvarez.companiessurveys.view.factory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.view.adapter.question.IScoreQuestionTextChanged
import com.salvarez.companiessurveys.view.adapter.IViewHolderItemSelected
import com.salvarez.companiessurveys.view.adapter.question.*
import com.salvarez.companiessurveys.view.adapter.question.viewholder.*

class ViewHolderQuestionFactory {

    companion object{
        fun getViewHolder(parent: ViewGroup, viewType: Int, mixedOptionSelected: IMixedOptionSelected, viewHolderItemSelected: IViewHolderItemSelected, scoreQuestionTextChanged: IScoreQuestionTextChanged): BaseQuestionViewHolder {
            var view: View? = null
           return when (viewType) {
                QuestionType.DROP_DOWN_QUESTION -> {
                    view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_mixed_question_dropdown, parent, false)
                    DropDownQuestionViewHolder(
                        view,
                        mixedOptionSelected
                    )
                }
                QuestionType.SINGLE_CHOOSE_QUESTION -> {
                    view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_mixed_question_single_choose, parent, false)
                    SingleChooseQuestionViewHolder(
                        view,
                        mixedOptionSelected
                    )
                }
                QuestionType.MULTIPLE_CHOOSE_QUESTION -> {
                    view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_mixed_question_multiple_choose, parent, false)
                    MultipleChooseQuestionViewHolder(
                        view,
                        mixedOptionSelected
                    )
                }
                else -> {
                    view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_score_question_create, parent, false)
                    ScoreQuestionViewHolder(view, viewHolderItemSelected , scoreQuestionTextChanged)
                }
            }
        }
    }
}