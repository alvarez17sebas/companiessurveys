package com.salvarez.companiessurveys.view.adapter.option.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.companiessurveys.model.dto.OptionDto

abstract class BaseOptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun drawOptionData(option: OptionDto)
}