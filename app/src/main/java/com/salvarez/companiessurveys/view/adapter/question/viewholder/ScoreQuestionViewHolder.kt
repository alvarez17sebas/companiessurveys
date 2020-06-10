package com.salvarez.companiessurveys.view.adapter.question.viewholder

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.constant.AdapterEvent
import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.model.dto.ScoreQuestionDto
import com.salvarez.companiessurveys.view.adapter.question.IScoreQuestionTextChanged
import com.salvarez.companiessurveys.view.adapter.IViewHolderItemSelected

class ScoreQuestionViewHolder(itemView: View, var viewHolderItemSelected: IViewHolderItemSelected, var textChanged: IScoreQuestionTextChanged) : BaseQuestionViewHolder(itemView) {
    var etQuestionContent: EditText = itemView.findViewById(R.id.etScoreQuestionContent)
    var etScore: EditText = itemView.findViewById(R.id.etScore)
    var ivDeleteQuestion: ImageView = itemView.findViewById(R.id.ivDeleteScoreQuestionItem)

    private fun clickBehaviors(){
        ivDeleteQuestion.setOnClickListener {
            viewHolderItemSelected.positionSelected(layoutPosition, AdapterEvent.DELETE_ACTION)
        }

        etQuestionContent.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                textChanged.textContentChanged(layoutPosition, s.toString())
            }

        })

        etScore.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if("" != s.toString()){
                    textChanged.textScoreChanged(layoutPosition, s.toString().toInt())
                }
            }

        })
    }

    override fun drawData(question: QuestionDto) {
        var scoreQuestion: ScoreQuestionDto = question as ScoreQuestionDto
        etQuestionContent.setText(scoreQuestion.question)
        etScore.setText(scoreQuestion.score.toString())

        clickBehaviors()
    }
}