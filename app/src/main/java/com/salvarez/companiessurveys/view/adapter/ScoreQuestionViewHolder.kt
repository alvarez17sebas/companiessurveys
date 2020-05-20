package com.salvarez.companiessurveys.view.adapter

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.companiessurveys.R

class ScoreQuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var etQuestionContent: EditText = itemView.findViewById(R.id.etQuestionContent)
    var etScore: EditText = itemView.findViewById(R.id.etScore)
    var ivDeleteQuestion: ImageView = itemView.findViewById(R.id.ivDeleteScoreQuestionItem)
}