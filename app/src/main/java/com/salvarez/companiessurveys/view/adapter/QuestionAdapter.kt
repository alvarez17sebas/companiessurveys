package com.salvarez.companiessurveys.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.constant.AdapterEvent
import com.salvarez.companiessurveys.model.dto.QuestionDto

class QuestionAdapter(var data:MutableList<QuestionDto>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), IViewHolderItemSelected {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_mixed_question_option_create, parent, false)

        if(viewType == QuestionType.SCORE_QUESTION){
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_score_question_create, parent, false)
            return ScoreQuestionViewHolder(view)
        }
        return MixedQuestionViewHolder(view, this)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var question = data[position]

        when(holder.itemViewType){

            QuestionType.SCORE_QUESTION ->{
                var scoreQuestionViewHolder: ScoreQuestionViewHolder  = holder as ScoreQuestionViewHolder
            }

            QuestionType.DROP_DOWN_QUESTION ->{
                var mixedQuestionViewHolder: MixedQuestionViewHolder  = holder as MixedQuestionViewHolder
                //mixedQuestionViewHolder.drawData(question)
            }

            QuestionType.SINGLE_CHOOSE_QUESTION ->{
            }

            QuestionType.MULTIPLE_CHOOSE_QUESTION ->{
            }

        }

    }

    override fun getItemViewType(position: Int): Int {
        val questionDto = data[position]
        return questionDto.getQuestionType()
    }

    override fun positionSelected(index: Int, event: Int) {
        when(event){
            AdapterEvent.DELETE_ACTION -> {
                data.removeAt(index)
            }
        }
        this.notifyItemRemoved(index)
    }

    fun addQuestion(question: QuestionDto){
        data.add(0, question)
        notifyItemInserted(0)
    }
}