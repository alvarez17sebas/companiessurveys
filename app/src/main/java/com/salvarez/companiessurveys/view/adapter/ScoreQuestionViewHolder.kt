package com.salvarez.companiessurveys.view.adapter

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.dto.QuestionDto

class ScoreQuestionViewHolder(itemView: View) : BaseViewHolder(itemView) {
    var etQuestionContent: EditText = itemView.findViewById(R.id.etQuestionContent)
    var etScore: EditText = itemView.findViewById(R.id.etScore)
    var ivDeleteQuestion: ImageView = itemView.findViewById(R.id.ivDeleteScoreQuestionItem)

    override fun drawData(question: QuestionDto) {
    }
}