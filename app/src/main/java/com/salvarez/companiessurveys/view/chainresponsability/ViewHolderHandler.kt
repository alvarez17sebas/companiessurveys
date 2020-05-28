package com.salvarez.companiessurveys.view.chainresponsability

abstract class ViewHolderHandler {

    protected lateinit var  nextViewHolderHandler: ViewHolderHandler


    abstract fun drawContent(typeQuestion: Int)

}