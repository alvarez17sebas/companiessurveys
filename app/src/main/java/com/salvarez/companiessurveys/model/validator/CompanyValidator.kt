package com.salvarez.companiessurveys.model.validator

import com.salvarez.companiessurveys.model.dto.CompanyDto

class CompanyValidator(var companyDto: CompanyDto) {

    fun validateInformation(): Boolean{
        return ("" != companyDto.nit && "" != companyDto.name)
    }
}