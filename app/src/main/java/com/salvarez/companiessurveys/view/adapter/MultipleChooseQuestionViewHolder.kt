package com.salvarez.companiessurveys.view.adapter

import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.model.dto.QuestionDto

class MultipleChooseQuestionViewHolder(itemView: View) : BaseViewHolder(itemView) {

    var titleQuestion: TextView = itemView.findViewById(R.id.tvTitleQuestionMultipleChoose)
    var checkboxesContent: LinearLayout = itemView.findViewById(R.id.linearLayoutContentCheckboxes)

    override fun drawData(question: QuestionDto){
        titleQuestion.text = question.question
        drawCheckboxOptions(question.options)
    }

    private fun drawCheckboxOptions(options: List<OptionDto>?){
        options?.forEach{
            var checkBox: CheckBox = CheckBox(itemView.context)
            checkBox.text = it.option
            checkboxesContent.addView(checkBox)
        }
    }
}