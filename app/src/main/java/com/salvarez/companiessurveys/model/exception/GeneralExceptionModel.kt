package com.salvarez.companiessurveys.model.exception

import java.lang.Exception

data class GeneralExceptionModel(var Exception: Exception, var exceptionMessageForUser: String = "")