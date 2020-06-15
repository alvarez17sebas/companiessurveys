package com.salvarez.companiessurveys.view.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.SurveyType
import com.salvarez.companiessurveys.model.*
import com.salvarez.companiessurveys.model.constant.TransferScreenKey
import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.model.dto.ScoreQuestionDto
import com.salvarez.companiessurveys.model.dto.SurveyDto
import com.salvarez.companiessurveys.model.factory.QuestionFactory
import com.salvarez.companiessurveys.view.adapter.question.QuestionAdapter
import com.salvarez.companiessurveys.view.fragment.ListOptionDialogFragment
import com.salvarez.companiessurveys.viewmodel.CreateSurveyViewModel
import kotlinx.android.synthetic.main.activity_create_survey.*

class CreateSurveyActivity : AppCompatActivity(), ITypeSelected {

    private val REQUEST_MIXED_QUESTION_CODE: Int = 1
    private val REQUEST_SCORE_QUESTION_CODE: Int = 2

    private lateinit var createSurveyVieModel: CreateSurveyViewModel

    private var typeSurvey: Int = -1
    private var questionAdapter: QuestionAdapter =
        QuestionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_survey)

        createSurveyVieModel = ViewModelProviders.of(this).get(CreateSurveyViewModel::class.java)

        getParameters()
        clickListenerBehaviors()
        setupRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.saveSurvey -> {
                wrapData()
                true
            }else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_CANCELED)
            return

        when(requestCode){
            REQUEST_MIXED_QUESTION_CODE -> {
                val questionType = data?.getIntExtra(TransferScreenKey.QUESTION_TYPE_KEY, -1)
                var question = QuestionFactory.getQuestion(questionType)
                val strQuestion: String? = data?.getStringExtra(TransferScreenKey.QUESTION_KEY)
                question = GsonHelper.strToObject(strQuestion!!, question) as QuestionDto
                questionAdapter.addQuestion(question)
            }

            REQUEST_SCORE_QUESTION_CODE -> {
                var strScoreQuestionList: String? = data?.getStringExtra(TransferScreenKey.QUESTION_KEY)
                var scoreQuestionList: MutableList<QuestionDto> = Gson().fromJson(strScoreQuestionList, object : TypeToken<MutableList<ScoreQuestionDto>>() {}.type)
                questionAdapter.addQuestions(scoreQuestionList)
            }
        }
    }

    private fun wrapData(){
        var surveyName: String = etSurveyName.text.toString()
        var surveyDescription = etSurveyDescription.text.toString()
        var surveyEnabled: Boolean = switchEnable.isChecked
        var currentDate: String = DateHelper.getCurrentDate(DateFormat.dd_mm_yyyyy_hh_mm_ss)

        var survey: SurveyDto = SurveyDto(surveyName, surveyDescription, typeSurvey, currentDate, surveyEnabled, questionAdapter.getAdapterContent())
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
                    var intent: Intent = Intent(this, CreateScoreQuestionActivity::class.java)
                    intent.putExtra(TransferScreenKey.QUESTION_TYPE_KEY, QuestionType.SCORE_QUESTION)
                    startActivityForResult(intent, REQUEST_SCORE_QUESTION_CODE)
                }
            }
        }
    }

    override fun typeSelected(type: Int) {
        when(type){
            QuestionType.DROP_DOWN_QUESTION -> {

                var intent: Intent = Intent(this, CreateMixedQuestionActivity::class.java)
                intent.putExtra(TransferScreenKey.QUESTION_TYPE_KEY, QuestionType.DROP_DOWN_QUESTION)
                startActivityForResult(intent, REQUEST_MIXED_QUESTION_CODE)
            }

            QuestionType.SINGLE_CHOOSE_QUESTION -> {
                var intent: Intent = Intent(this, CreateMixedQuestionActivity::class.java)
                intent.putExtra(TransferScreenKey.QUESTION_TYPE_KEY, QuestionType.SINGLE_CHOOSE_QUESTION)
                startActivityForResult(intent, REQUEST_MIXED_QUESTION_CODE)
            }

            QuestionType.MULTIPLE_CHOOSE_QUESTION -> {
                var intent: Intent = Intent(this, CreateMixedQuestionActivity::class.java)
                intent.putExtra(TransferScreenKey.QUESTION_TYPE_KEY, QuestionType.MULTIPLE_CHOOSE_QUESTION)
                startActivityForResult(intent, REQUEST_MIXED_QUESTION_CODE)
            }
        }
    }
}
