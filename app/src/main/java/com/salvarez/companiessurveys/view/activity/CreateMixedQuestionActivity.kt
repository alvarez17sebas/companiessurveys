package com.salvarez.companiessurveys.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.GsonHelper
import com.salvarez.companiessurveys.model.constant.TransferScreenKey
import com.salvarez.companiessurveys.model.dto.*
import com.salvarez.companiessurveys.model.factory.OptionFactory
import com.salvarez.companiessurveys.view.adapter.option.OptionAdapter
import com.salvarez.companiessurveys.viewmodel.CreateMixedQuestionViewModel
import kotlinx.android.synthetic.main.activity_create_mixed_question.*

class CreateMixedQuestionActivity : AppCompatActivity() {

    private lateinit var createMixedQuestionViewModel: CreateMixedQuestionViewModel

    private var optionAdapter: OptionAdapter = OptionAdapter()
    private var questionType: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_mixed_question)

        createMixedQuestionViewModel = ViewModelProviders.of(this).get(CreateMixedQuestionViewModel::class.java)

        getParameters()

        setupRecyclerView()

        clickListenerBehaviors()
    }

    private fun setupRecyclerView(){
        val layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        rvMixedQuestions.layoutManager = layoutManager
        rvMixedQuestions.adapter = optionAdapter
    }

    private fun getParameters(){
        questionType = intent.getIntExtra(TransferScreenKey.QUESTION_TYPE_KEY, -1)
    }

    private fun clickListenerBehaviors(){
        fabAddScoreQuestion.setOnClickListener {

            var option: OptionDto = createMixedQuestionViewModel.getEmptyQuestionDto(questionType)

            optionAdapter?.addOption(option)
        }

        var intent: Intent = Intent()

        btnScoreQuestionSave.setOnClickListener {

            var questionText: String = etMixedQuestion.text.toString()
            var options:MutableList<OptionDto> = optionAdapter.getAdapterContent()

            var question: QuestionDto = createMixedQuestionViewModel.getFillQuestionDto(questionType, questionText, options)

            intent.putExtra(TransferScreenKey.QUESTION_TYPE_KEY, question.getQuestionType())
            intent.putExtra(TransferScreenKey.QUESTION_KEY, GsonHelper.objectToString(question))
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        btnScoreQuestionCancel.setOnClickListener{
            setResult(Activity.RESULT_CANCELED, intent)
            finish()
        }
    }


}
