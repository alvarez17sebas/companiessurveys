package com.salvarez.companiessurveys.model.exception

import java.lang.Exception

interface IBehaviorException {
    fun processException(generalExceptionModel: GeneralExceptionModel)
}