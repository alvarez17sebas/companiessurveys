package com.salvarez.companiessurveys.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.constant.AdapterEvent
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.view.factory.ViewHolderQuestionFactory

class QuestionAdapter : RecyclerView.Adapter<BaseViewHolder>(), IViewHolderItemSelected, IOptionSelected {

    private var data: MutableList<QuestionDto> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        return ViewHolderQuestionFactory.getViewHolder(parent, viewType, this)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        var question = data[position]

        holder.drawData(question)

    }

    override fun getItemViewType(position: Int): Int {
        val questionDto = data[position]
        return questionDto.getQuestionType()
    }

    override fun positionSelected(index: Int, event: Int) {
        when (event) {
            AdapterEvent.DELETE_ACTION -> {
                data.removeAt(index)
            }
        }
        this.notifyItemRemoved(index)
    }

    fun addQuestion(question: QuestionDto) {
        data.add(question)
        notifyItemInserted(data.size - 1)
    }

    private fun updateQuestion(positionQuestion: Int, newQuestion: QuestionDto){
        data.removeAt(positionQuestion)
        data.add(positionQuestion, newQuestion)
    }

    override fun optionSelected(questionPosition: Int, optionPOsition: Int) {
        var question:QuestionDto = data[questionPosition]
        var option: OptionDto? = question.options?.get(optionPOsition)

        question.options?.forEach {
            if(option?.idOption == it.idOption){
                it.selected = !it.selected
            }else{
                it.selected = false
            }
        }
        updateQuestion(questionPosition, question)

        Log.i("options", "Opción seleccionada: ${option?.option}")

    }

}