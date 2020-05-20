package com.salvarez.companiessurveys.model.repository

import com.salvarez.companiessurveys.model.exception.GeneralExceptionModel

interface IRepositoryCallback<T> {
    fun onSuccess(result: T?)
    fun onFailed(generalExceptionModel: GeneralExceptionModel)
}