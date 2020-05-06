package com.salvarez.companiessurveys.model.mapping

import com.google.gson.Gson
import com.salvarez.companiessurveys.model.dto.CompanyDto
import com.salvarez.companiessurveys.model.entity.CompanyEntity

class CompanyMapping {

    companion object{

        fun companyDtoToCompanyEntity(companyDto: CompanyDto): CompanyEntity{
            var gson = Gson()
            var strJson = gson.toJson(companyDto)
            return gson.fromJson(strJson, CompanyEntity::class.java)
        }

        fun companyEntityToCompanyDto(companyEntity: CompanyEntity): CompanyDto{
            var gson = Gson()
            var strJson = gson.toJson(companyEntity)
            return gson.fromJson(strJson, CompanyDto::class.java)
        }

    }

}