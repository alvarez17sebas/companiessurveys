package com.salvarez.companiessurveys.model.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.salvarez.companiessurveys.model.CollectionsFirestore
import com.salvarez.companiessurveys.model.dto.CompanyDto
import com.salvarez.companiessurveys.model.exception.GeneralExceptionModel

class RemoteRepositoryImpl : IRemoteRepository {

    private var fireStorage = FirebaseFirestore.getInstance()

    override fun registerCompany(
        companyDto: CompanyDto,
        IRepositoryCallback: IRepositoryCallback<Boolean>
    ) {
        fireStorage.collection(CollectionsFirestore.COMPANIES_COLLECTION)
            .add(companyDto)
            .addOnSuccessListener {
                IRepositoryCallback.onSuccess(true)
            }
            .addOnFailureListener{
                var exception = GeneralExceptionModel(it, "Ha ocurrido un error en su registro, por favor intentelo mas tarde.")
                IRepositoryCallback.onFailed(exception)
            }
    }


}