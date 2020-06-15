package com.salvarez.companiessurveys.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.constant.TransferScreenKey
import com.salvarez.companiessurveys.model.dto.ScoreQuestionDto
import com.salvarez.companiessurveys.view.adapter.question.QuestionAdapter
import com.salvarez.companiessurveys.viewmodel.CreateScoreQuestionViewModel
import kotlinx.android.synthetic.main.activity_create_score_question.*

class CreateScoreQuestionActivity : AppCompatActivity() {

    private lateinit var createScoreQuestionViewModel: CreateScoreQuestionViewModel

    private var questionAdapter: QuestionAdapter = QuestionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_score_question)

        createScoreQuestionViewModel = ViewModelProviders.of(this).get(CreateScoreQuestionViewModel::class.java)

        setupRecyclerView()
        clickBehaviors()
    }

    private fun setupRecyclerView(){
        var layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        rvScoreQuestions.layoutManager = layoutManager
        rvScoreQuestions.adapter = questionAdapter
    }

    private fun clickBehaviors(){

        var intent: Intent = Intent()

        fabAddScoreQuestion.setOnClickListener {
            var scoreQuestion: ScoreQuestionDto = createScoreQuestionViewModel.getEmptyScoreQuestion(QuestionType.SCORE_QUESTION)
            questionAdapter.addQuestion(scoreQuestion)
        }

        btnScoreQuestionSave.setOnClickListener {
            var scoreQuestionList: MutableList<ScoreQuestionDto> =  questionAdapter.getAdapterContent() as MutableList<ScoreQuestionDto>

            intent.putExtra(TransferScreenKey.QUESTION_TYPE_KEY, QuestionType.SCORE_QUESTION)
            intent.putExtra(TransferScreenKey.QUESTION_KEY, createScoreQuestionViewModel.getStrScoreQuestions(scoreQuestionList))
            setResult(Activity.RESULT_OK, intent)
            finish()

        }

        btnScoreQuestionCancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED, intent)
            finish()
        }
    }
}
