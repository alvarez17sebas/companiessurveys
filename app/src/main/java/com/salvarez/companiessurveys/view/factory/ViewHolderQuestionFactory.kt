package com.salvarez.companiessurveys.view.factory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.view.adapter.*

class ViewHolderQuestionFactory {

    companion object{
        fun getViewHolder(parent: ViewGroup, viewType: Int, optionSelected: IOptionSelected): BaseViewHolder{
            var view: View? = null
           return when (viewType) {
                QuestionType.DROP_DOWN_QUESTION -> {
                    view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_mixed_question_dropdown, parent, false)
                    DropDownViewHolder(view)
                }
                QuestionType.SINGLE_CHOOSE_QUESTION -> {
                    view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_mixed_question_single_choose, parent, false)
                    SingleChooseQuestionViewHolder(view, optionSelected)
                }
                QuestionType.MULTIPLE_CHOOSE_QUESTION -> {
                    view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_mixed_question_multiple_choose, parent, false)
                    MultipleChooseQuestionViewHolder(view)
                }
                else -> {
                    view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_score_question_create, parent, false)
                    ScoreQuestionViewHolder(view)
                }
            }
        }
    }
}