package com.salvarez.companiessurveys.model.domain

import com.salvarez.companiessurveys.model.dto.CompanyDto
import com.salvarez.companiessurveys.model.exception.GeneralExceptionModel
import com.salvarez.companiessurveys.model.repository.IRemoteRepository
import com.salvarez.companiessurveys.model.repository.IRepositoryCallback
import com.salvarez.companiessurveys.model.repository.RemoteRepositoryImpl

class CompanyDomain {

    private var remoteRepository = RemoteRepositoryImpl()

    fun registerCompany(companyDto: CompanyDto){
        remoteRepository.registerCompany(companyDto, object: IRepositoryCallback<Boolean>{
            override fun onSuccess(result: Boolean?) {
                TODO("Not yet implemented")
            }

            override fun onFailed(generalExceptionModel: GeneralExceptionModel) {
                TODO("Not yet implemented")
            }

        })
    }
}