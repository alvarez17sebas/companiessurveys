package com.salvarez.companiessurveys.view.adapter

import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.model.dto.QuestionDto

class SingleChooseQuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvTitleQuestionSingleChoose: TextView = itemView.findViewById(R.id.tvTitleQuestionSingleChoose)
    var radioGroup: RadioGroup = itemView.findViewById(R.id.radioGroupSingleChoose)

    fun drawData(question: QuestionDto){
        tvTitleQuestionSingleChoose.text = question.question
        drawRadioButtonOptions(question.options)
    }

    private fun drawRadioButtonOptions(options: List<OptionDto>?){
        options?.forEach{
            var radioButton: RadioButton = RadioButton(itemView.context)
            radioButton.text = it.option
            radioGroup.addView(radioButton)
        }
    }
}