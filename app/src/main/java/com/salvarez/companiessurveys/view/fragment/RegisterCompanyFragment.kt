package com.salvarez.companiessurveys.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.dto.CompanyDto
import com.salvarez.companiessurveys.view.activity.ContainerOptionsActivity
import com.salvarez.companiessurveys.viewmodel.RegisterCompanyViewModel
import kotlinx.android.synthetic.main.fragment_register_company.*
import kotlinx.android.synthetic.main.fragment_register_company.view.*
import kotlinx.android.synthetic.main.progress_layout.*

class RegisterCompanyFragment : Fragment() {

    private lateinit var registerCompanyViewModel: RegisterCompanyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        registerCompanyViewModel = ViewModelProviders.of(this).get(RegisterCompanyViewModel::class.java)

        return inflater.inflate(R.layout.fragment_register_company, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        executeListener()
        behaviorObserves()
    }

    private fun executeListener(){
        btnRegisterConfirmation.setOnClickListener {
            registerCompanyViewModel.registerCompany(buildCompanyDtoObject())
        }
    }

    private fun buildCompanyDtoObject(): CompanyDto{
        val nit = etNit.text.toString()
        val nameCompany = etNameCompany.text.toString()

        return CompanyDto(nit, nameCompany)
    }

    private fun behaviorObserves(){

        registerCompanyViewModel.loading.observe(this, Observer {
            if(it){
                enableFields(false)
                constraintProgressContainer.visibility = View.VISIBLE
            }else{
                enableFields(true)
                constraintProgressContainer.visibility = View.GONE
            }
        })

        registerCompanyViewModel.requestSuccess.observe(this, Observer {
            startActivity(Intent(context, ContainerOptionsActivity::class.java))
        })

        registerCompanyViewModel.requestFailed.observe(this, Observer {
            Toast.makeText(context, it.exceptionMessageForUser, Toast.LENGTH_SHORT).show()
        })
    }

    private fun enableFields(status: Boolean){
        etNit.isEnabled = status
        etNameCompany.isEnabled = status
        btnRegisterConfirmation.isEnabled = status
    }
}