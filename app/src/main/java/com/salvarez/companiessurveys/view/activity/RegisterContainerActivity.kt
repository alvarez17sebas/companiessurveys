package com.salvarez.companiessurveys.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.view.fragment.RegisterCompanyFragment

class RegisterContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_container)


        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = RegisterCompanyFragment()
        fragmentTransaction.add(R.id.fragmentContainerRegister, fragment)
        fragmentTransaction.commit()
    }
}
