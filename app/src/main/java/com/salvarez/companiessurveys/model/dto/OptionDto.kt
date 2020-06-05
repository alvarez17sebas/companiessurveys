package com.salvarez.companiessurveys.model.dto

import com.salvarez.companiessurveys.OptionType

open class OptionDto(){

    var idOption: Int = 0
    var option: String = ""
    var selected: Boolean = false

    open fun getOptionType(): Int{
        return OptionType.MIXED_OPTION
    }
}