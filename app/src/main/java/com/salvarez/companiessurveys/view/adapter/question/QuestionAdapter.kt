package com.salvarez.companiessurveys.view.adapter.question

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.view.adapter.question.viewholder.BaseQuestionViewHolder
import com.salvarez.companiessurveys.view.factory.ViewHolderQuestionFactory

class QuestionAdapter : RecyclerView.Adapter<BaseQuestionViewHolder>(){

    private var data: MutableList<QuestionDto> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseQuestionViewHolder {

        return ViewHolderQuestionFactory
            .getViewHolder(parent,
                viewType,
                MixedQuestionOptionSelectedImpl(
                    data
                ),
                ViewHolderQuestionSelectedImpl(
                    data,
                    this
                ),
                ScoreQuestionTextChangedImpl(
                    data
                )
            )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holderQuestion: BaseQuestionViewHolder, position: Int) {

        var question = data[position]

        holderQuestion.drawData(question)

    }

    override fun getItemViewType(position: Int): Int {
        val questionDto = data[position]
        return questionDto.getQuestionType()
    }

    fun addQuestion(question: QuestionDto) {
        data.add(question)
        notifyItemInserted(data.size - 1)
    }

    fun addQuestions(questionList: MutableList<QuestionDto>){
        data = questionList
        notifyDataSetChanged()
    }

    fun getAdapterContent(): MutableList<QuestionDto>{
        return data
    }
}