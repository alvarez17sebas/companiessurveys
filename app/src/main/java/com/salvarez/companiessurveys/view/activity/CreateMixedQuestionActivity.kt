package com.salvarez.companiessurveys.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.dto.DropDownQuestionDto
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.view.adapter.OptionAdapter
import kotlinx.android.synthetic.main.activity_create_mixed_question.*

class CreateMixedQuestionActivity : AppCompatActivity() {

    private var optionAdapter: OptionAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_mixed_question)

        optionAdapter = OptionAdapter()

        setupRecyclerView()

        clickListenerBehaviors()
    }

    private fun setupRecyclerView(){
        val layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        rvMixedQuestions.layoutManager = layoutManager
        rvMixedQuestions.adapter = optionAdapter
    }

    private fun clickListenerBehaviors(){
        fabAddTypeMixedQuestion.setOnClickListener {
            var option: OptionDto = OptionDto()
            optionAdapter?.addOption(option)
        }

        btnSave.setOnClickListener {
            var question: QuestionDto = DropDownQuestionDto()
            question.question = etMixedQuestion.text.toString()
            question.options = optionAdapter?.getAdapterContent()

            var intent: Intent = Intent()
            intent.putExtra("question", question)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        btnCancel.setOnClickListener{
            finish()
        }
    }


}
