package com.salvarez.companiessurveys.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.salvarez.companiessurveys.BaseResponse
import com.salvarez.companiessurveys.model.dto.CompanyDto
import com.salvarez.companiessurveys.model.exception.GeneralExceptionModel
import com.salvarez.companiessurveys.model.repository.IRepositoryCallback
import com.salvarez.companiessurveys.model.repository.RemoteRepositoryImpl
import com.salvarez.companiessurveys.model.validator.CompanyValidator

class RegisterCompanyViewModel(application: Application) : AndroidViewModel(application) {

    private val remoteRepository = RemoteRepositoryImpl()

    private val _requestSuccess: MutableLiveData<BaseResponse<Boolean>> = MutableLiveData()
    val requestSuccess: LiveData<BaseResponse<Boolean>> = _requestSuccess

    private val _requestFailed: MutableLiveData<GeneralExceptionModel> = MutableLiveData()
    val requestFailed: LiveData<GeneralExceptionModel> = _requestFailed

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: MutableLiveData<Boolean> = _loading

    fun registerCompany(companyDto: CompanyDto){

        _loading.value = true

        val companyValidator: CompanyValidator = CompanyValidator(companyDto)

        if(companyValidator.validateInformation()){

            callRemoteRepository(companyDto)

        }else{
            _loading.value = false
            _requestFailed.value = GeneralExceptionModel(Exception(), "Todos los campos son obligatorios")
        }


    }

    private fun callRemoteRepository(companyDto: CompanyDto){
        remoteRepository.registerCompany(companyDto, object: IRepositoryCallback<Boolean>{
            override fun onSuccess(response: Boolean?) {
                var response: BaseResponse<Boolean> = BaseResponse(true, null)
                _loading.value = false
                _requestSuccess.value = response
            }

            override fun onFailed(generalExceptionModel: GeneralExceptionModel) {
                _loading.value = false
                _requestFailed.value = generalExceptionModel
            }

        })
    }

}