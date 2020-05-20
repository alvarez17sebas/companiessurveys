package com.salvarez.companiessurveys.model.exception

import android.util.Log
import java.lang.Exception

class ResponseException(message: String?) : Exception(message), IBehaviorException {
    override fun processException(generalExceptionModel: GeneralExceptionModel) {
        Log.i("exception,", generalExceptionModel.Exception.message)
    }

}