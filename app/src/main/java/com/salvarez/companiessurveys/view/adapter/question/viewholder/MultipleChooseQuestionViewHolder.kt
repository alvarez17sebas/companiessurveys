package com.salvarez.companiessurveys.view.adapter.question.viewholder

import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.view.adapter.question.IMixedOptionSelected

class MultipleChooseQuestionViewHolder(itemView: View, var mixedOptionSelected: IMixedOptionSelected) : BaseQuestionViewHolder(itemView) {

    var titleQuestion: TextView = itemView.findViewById(R.id.tvTitleQuestionMultipleChoose)
    var checkboxesContent: LinearLayout = itemView.findViewById(R.id.linearLayoutContentCheckboxes)

    override fun drawData(question: QuestionDto){
        titleQuestion.text = question.question
        drawCheckboxOptions(question.options)

    }

    private fun drawCheckboxOptions(options: MutableList<OptionDto>?){
        options?.forEach{
            var checkBox: CheckBox = CheckBox(itemView.context)
            checkBox.id = it.idOption
            checkBox.text = it.option
            checkboxesContent.addView(checkBox)
            clickBehaviors(checkBox, options)
        }
    }

    private fun clickBehaviors(checkBox: CheckBox, options: MutableList<OptionDto>?){
        checkBox.setOnClickListener{
            var checkBoxSelected: CheckBox = it as CheckBox
            val idCheckBox = checkBox.id
            for (i in 0..options!!.size){
                if(options[i].idOption == idCheckBox){
                    mixedOptionSelected.optionSelected(layoutPosition, i, QuestionType.MULTIPLE_CHOOSE_QUESTION)
                    break
                }
            }
        }
    }
}