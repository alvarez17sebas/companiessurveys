package com.salvarez.companiessurveys.view.adapter

import com.salvarez.companiessurveys.model.dto.OptionDto

interface IOptionSelected {
    fun optionSelected(questionPosition: Int, optionPosition: Int)
}