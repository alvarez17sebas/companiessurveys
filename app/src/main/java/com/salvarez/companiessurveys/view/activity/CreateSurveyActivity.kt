package com.salvarez.companiessurveys.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.SurveyType
import com.salvarez.companiessurveys.model.BuildContentArray
import com.salvarez.companiessurveys.model.GsonHelper
import com.salvarez.companiessurveys.model.ITypeSelected
import com.salvarez.companiessurveys.model.constant.TransferScreenKey
import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.model.factory.QuestionFactory
import com.salvarez.companiessurveys.view.adapter.QuestionAdapter
import com.salvarez.companiessurveys.view.fragment.ListOptionDialogFragment
import kotlinx.android.synthetic.main.activity_create_survey.*

private const val REQUEST_QUESTION_CODE: Int = 1

class CreateSurveyActivity : AppCompatActivity(), ITypeSelected {

    private var typeSurvey: Int = -1
    private var questionAdapter: QuestionAdapter = QuestionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_survey)

        getParameters()
        clickListenerBehaviors()
        setupRecyclerView()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            REQUEST_QUESTION_CODE -> {
                val questionType = data?.getIntExtra(TransferScreenKey.QUESTION_TYPE_KEY, -1)
                var question = QuestionFactory.getQuestion(questionType)
                val strQuestion: String? = data?.getStringExtra(TransferScreenKey.QUESTION_KEY)
                question = GsonHelper.strToObject(strQuestion!!, question) as QuestionDto
                questionAdapter.addQuestion(question)
            }
        }
    }

    private fun getParameters(){
        typeSurvey = intent.getIntExtra(TransferScreenKey.SURVEY_TYPE_KEY, -1)
    }

    private fun setupRecyclerView(){
        var layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        rvQuestionsCreateSurvey.layoutManager = layoutManager
        rvQuestionsCreateSurvey.adapter = questionAdapter
    }

    private fun clickListenerBehaviors(){
        fabAddQuestion.setOnClickListener {
            when(typeSurvey){
                SurveyType.MIXED_SURVEY -> {

                    val optionsDialog: ListOptionDialogFragment = ListOptionDialogFragment(BuildContentArray.questionMixedTypesArray(), this)
                    optionsDialog.show(supportFragmentManager, "tag")

                }

                SurveyType.SCORE_SURVEY -> {
                    Toast.makeText(this, "ScoreSurvey", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun typeSelected(type: Int) {
        when(type){
            QuestionType.DROP_DOWN_QUESTION -> {

                var intent: Intent = Intent(this, CreateMixedQuestionActivity::class.java)
                intent.putExtra(TransferScreenKey.QUESTION_TYPE_KEY, QuestionType.DROP_DOWN_QUESTION)
                startActivityForResult(intent, REQUEST_QUESTION_CODE)
            }

            QuestionType.SINGLE_CHOOSE_QUESTION -> {
                var intent: Intent = Intent(this, CreateMixedQuestionActivity::class.java)
                intent.putExtra(TransferScreenKey.QUESTION_TYPE_KEY, QuestionType.SINGLE_CHOOSE_QUESTION)
                startActivityForResult(intent, REQUEST_QUESTION_CODE)
            }

            QuestionType.MULTIPLE_CHOOSE_QUESTION -> {
                var intent: Intent = Intent(this, CreateMixedQuestionActivity::class.java)
                intent.putExtra(TransferScreenKey.QUESTION_TYPE_KEY, QuestionType.MULTIPLE_CHOOSE_QUESTION)
                startActivityForResult(intent, REQUEST_QUESTION_CODE)
            }
        }
    }
}
