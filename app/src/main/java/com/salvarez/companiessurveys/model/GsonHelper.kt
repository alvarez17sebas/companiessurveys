package com.salvarez.companiessurveys.model

import com.google.gson.Gson

class GsonHelper {
    companion object{

        fun <T>objectToString(anyObject: T): String{
            var gson = Gson()
            return gson.toJson(anyObject)
        }

        fun strToObject(strObject: String, myClass: Any): Any{
            var gson = Gson()
            return gson.fromJson(strObject, myClass::class.java)
        }
    }
}