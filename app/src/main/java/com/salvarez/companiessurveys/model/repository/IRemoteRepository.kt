package com.salvarez.companiessurveys.model.repository

import com.salvarez.companiessurveys.model.dto.CompanyDto

interface IRemoteRepository {
    fun registerCompany(companyDto: CompanyDto, IRepositoryCallback: IRepositoryCallback<Boolean>)
}