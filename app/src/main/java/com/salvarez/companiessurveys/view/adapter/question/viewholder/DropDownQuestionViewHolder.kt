package com.salvarez.companiessurveys.view.adapter.question.viewholder

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.view.adapter.question.IMixedOptionSelected

class DropDownQuestionViewHolder(itemView: View, var mixedOptionSelected: IMixedOptionSelected) : BaseQuestionViewHolder(itemView) {
    var tvTitle:TextView = itemView.findViewById(R.id.tvTitleQuestionDropDown)
    var spinnerOptions: Spinner = itemView.findViewById(R.id.spinnerOptionDropDown)

    var adapter: ArrayAdapter<String>? = null

    private fun getStrOptionsList(list: MutableList<OptionDto>?): ArrayList<String>{
        var strList: ArrayList<String> = ArrayList()
        list?.forEach {
            strList.add(it.option)
        }
        return strList
    }

    private fun clickBehaviors(){
        spinnerOptions.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                mixedOptionSelected.optionSelected(layoutPosition, position, QuestionType.DROP_DOWN_QUESTION)
            }
        }
    }

    override fun drawData(question: QuestionDto){
        tvTitle.text = question.question

        adapter = ArrayAdapter(itemView.context, R.layout.support_simple_spinner_dropdown_item, getStrOptionsList(question.options))
        spinnerOptions.adapter = adapter

        clickBehaviors()

    }
}