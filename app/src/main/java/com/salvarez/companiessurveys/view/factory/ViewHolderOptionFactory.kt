package com.salvarez.companiessurveys.view.factory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.salvarez.companiessurveys.OptionType
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.view.adapter.option.IMixedOptionTextChanged
import com.salvarez.companiessurveys.view.adapter.option.IScoreQuestionTextChanged
import com.salvarez.companiessurveys.view.adapter.option.IViewHolderItemSelected
import com.salvarez.companiessurveys.view.adapter.option.viewholder.BaseOptionViewHolder
import com.salvarez.companiessurveys.view.adapter.option.viewholder.OptionViewHolder

class ViewHolderOptionFactory {

    companion object{
        fun getViewHolder(parent: ViewGroup,
                          viewType: Int,
                          viewHolderOptionSelected: IViewHolderItemSelected,
                          optionMixedOptionTextChanged: IMixedOptionTextChanged,
                          scoreQuestionTextChanged: IScoreQuestionTextChanged): BaseOptionViewHolder{
            var view: View? = null
            return when(viewType){
                OptionType.MIXED_OPTION -> {
                    view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_mixed_question_option_create, parent, false)
                    OptionViewHolder(view, viewHolderOptionSelected, optionMixedOptionTextChanged)
                }else -> {
                        null!!
                }
            }
        }
    }
}