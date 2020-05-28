package com.salvarez.companiessurveys.view.adapter

import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.model.dto.QuestionDto

class DropDownViewHolder(itemView: View) : BaseViewHolder(itemView) {
    var tvTitle:TextView = itemView.findViewById(R.id.tvTitleQuestionDropDown)
    var spinnerOptions: Spinner = itemView.findViewById(R.id.spinnerOptionDropDown)

    var adapter: ArrayAdapter<String>? = null

    override fun drawData(question: QuestionDto){
        tvTitle.text = question.question

        adapter = ArrayAdapter(itemView.context, R.layout.support_simple_spinner_dropdown_item, getStrOptionsList(question.options))
        spinnerOptions.adapter = adapter

    }

    private fun getStrOptionsList(list: MutableList<OptionDto>?): ArrayList<String>{
        var strList: ArrayList<String> = ArrayList()
        list?.forEach {
            strList.add(it.option)
        }
        return strList
    }
}