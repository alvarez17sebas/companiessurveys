package com.salvarez.companiessurveys.view.adapter.question.viewholder

import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.view.adapter.question.IMixedOptionSelected

class SingleChooseQuestionViewHolder(itemView: View, var mixedOptionSelected: IMixedOptionSelected) :
    BaseQuestionViewHolder(itemView) {

    var tvTitleQuestionSingleChoose: TextView = itemView.findViewById(R.id.tvTitleQuestionSingleChoose)
    var radioGroup: RadioGroup = itemView.findViewById(R.id.radioGroupSingleChoose)

    override fun drawData(question: QuestionDto) {
        tvTitleQuestionSingleChoose.text = question.question
        drawRadioButtonOptions(question.options)
        clickBehaviors(question.options)
    }

    private fun drawRadioButtonOptions(options: List<OptionDto>?){
        options?.forEach{
            var radioButton: RadioButton = RadioButton(itemView.context)
            radioButton.id = it.idOption
            radioButton.text = it.option
            radioGroup.addView(radioButton)
        }
    }

    private fun clickBehaviors(options: MutableList<OptionDto>?){
        radioGroup.setOnCheckedChangeListener { _, checkedId ->

            for (i in 0..options!!.size){
                if(options[i].idOption == checkedId){
                    mixedOptionSelected.optionSelected(layoutPosition, i, QuestionType.SINGLE_CHOOSE_QUESTION)
                    break
                }
            }
        }
    }

}