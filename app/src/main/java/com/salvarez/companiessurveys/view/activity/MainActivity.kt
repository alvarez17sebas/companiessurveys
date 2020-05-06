package com.salvarez.companiessurveys.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.view.ScreenSlidePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagerAdapter =
            ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter

        btnRegisterCompany.setOnClickListener {
            startActivity(Intent(this, RegisterCompanyActivity::class.java))
        }
    }
}
