package com.salvarez.companiessurveys.model.dto

import com.salvarez.companiessurveys.OptionType

class ScoreOptionDto : OptionDto() {
    var score: Int = 0

    override fun getOptionType(): Int {
        return OptionType.SCORE_OPTION
    }
}