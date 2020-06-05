package com.salvarez.companiessurveys.model

import java.text.SimpleDateFormat
import java.util.*

class DateHelper {
    companion object{
        fun getCurrentDate(format: String): String{
            var dateFormat = SimpleDateFormat(format)
            return dateFormat.format(Date())
        }
    }
}