package com.salvarez.companiessurveys.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.companiessurveys.model.dto.QuestionDto

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun drawData(question: QuestionDto)

}