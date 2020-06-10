package com.salvarez.companiessurveys.view.adapter.option

import com.salvarez.companiessurveys.model.constant.AdapterEvent
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.view.adapter.IViewHolderItemSelected

class ViewHolderOptionSelectedImpl(var data: MutableList<OptionDto>, var optionAdapter: OptionAdapter) :
    IViewHolderItemSelected {
    override fun positionSelected(index: Int, event: Int) {
        when(event){
            AdapterEvent.DELETE_ACTION -> {
                data.removeAt(index)
                optionAdapter.notifyItemRemoved(index)
            }
        }
    }
}