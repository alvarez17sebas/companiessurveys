package com.salvarez.companiessurveys.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.SurveyType
import com.salvarez.companiessurveys.model.BuildContentArray
import com.salvarez.companiessurveys.model.ITypeSelected
import com.salvarez.companiessurveys.model.constant.TransferScreenKey
import com.salvarez.companiessurveys.view.fragment.ListOptionDialogFragment
import kotlinx.android.synthetic.main.activity_container_options.*

class ContainerOptionsActivity : AppCompatActivity(), ITypeSelected {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container_options)

        clickListenerBehaviors()
    }

    private fun clickListenerBehaviors(){
        btnCreateSurvey.setOnClickListener {
            val optionsDialog: ListOptionDialogFragment = ListOptionDialogFragment(BuildContentArray.surveyTypesArray(), this)
            optionsDialog.show(supportFragmentManager, "tag")
        }
    }

    override fun typeSelected(type: Int) {
        when(type){
            SurveyType.SCORE_SURVEY -> {

                var intent: Intent = Intent(this, CreateSurveyActivity::class.java)
                intent.putExtra(TransferScreenKey.SURVEY_TYPE_KEY, SurveyType.SCORE_SURVEY)
                startActivity(intent)
            }

            SurveyType.MIXED_SURVEY -> {
                var intent: Intent = Intent(this, CreateSurveyActivity::class.java)
                intent.putExtra(TransferScreenKey.SURVEY_TYPE_KEY, SurveyType.MIXED_SURVEY)
                startActivity(intent)
            }
        }
    }
}
