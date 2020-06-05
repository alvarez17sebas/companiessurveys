package com.salvarez.companiessurveys.view.adapter

import com.salvarez.companiessurveys.model.constant.AdapterEvent
import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.view.adapter.option.IViewHolderItemSelected

class ViewHolderItemSelectedImpl(var data: MutableList<QuestionDto>) : IViewHolderItemSelected {

    override fun positionSelected(index: Int, event: Int) {
        when (event) {
            AdapterEvent.DELETE_ACTION -> {
                data.removeAt(index)
            }
        }
        //this.notifyItemRemoved(index)
    }
}