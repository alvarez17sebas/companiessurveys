package com.salvarez.companiessurveys.view.adapter.question

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.model.constant.AdapterEvent
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.model.dto.QuestionDto
import com.salvarez.companiessurveys.model.dto.ScoreOptionDto
import com.salvarez.companiessurveys.model.dto.ScoreQuestionDto
import com.salvarez.companiessurveys.view.adapter.option.IScoreQuestionTextChanged
import com.salvarez.companiessurveys.view.adapter.option.IViewHolderItemSelected
import com.salvarez.companiessurveys.view.adapter.question.viewholder.BaseQuestionViewHolder
import com.salvarez.companiessurveys.view.factory.ViewHolderQuestionFactory

class QuestionAdapter : RecyclerView.Adapter<BaseQuestionViewHolder>(),
    IViewHolderItemSelected,
    IOptionSelected, IScoreQuestionTextChanged{

    private var data: MutableList<QuestionDto> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseQuestionViewHolder {

        return ViewHolderQuestionFactory.getViewHolder(parent, viewType, this,this, this)
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

    fun addQuestions(questionList: MutableList<QuestionDto>){
        data = questionList
        notifyDataSetChanged()
    }

    private fun updateQuestion(positionQuestion: Int, newQuestion: QuestionDto){
        data.removeAt(positionQuestion)
        data.add(positionQuestion, newQuestion)
    }

    fun getAdapterContent(): MutableList<QuestionDto>{
        return data
    }

    override fun optionSelected(questionPosition: Int, optionPOsition: Int, questionType: Int) {
        var question:QuestionDto = data[questionPosition]
        var option: OptionDto? = question.options?.get(optionPOsition)

        when(questionType){

            QuestionType.DROP_DOWN_QUESTION -> {
                question.options?.forEach {
                    if(option?.idOption == it.idOption){
                        it.selected = !it.selected
                    }else{
                        it.selected = false
                    }
                }
            }

            QuestionType.SINGLE_CHOOSE_QUESTION -> {

                question.options?.forEach {
                    if(option?.idOption == it.idOption){
                        it.selected = !it.selected
                    }else{
                        it.selected = false
                    }
                }
            }

            QuestionType.MULTIPLE_CHOOSE_QUESTION -> {
                question.options.forEach {
                    if(option?.idOption == it.idOption){
                        it.selected = !it.selected
                    }
                }
            }
        }

        updateQuestion(questionPosition, question)

        Log.i("options", "Opción seleccionada: ${option?.option}")

    }

    override fun textContentChanged(index: Int, text: String) {
        data[index].question = text
    }

    override fun textScoreChanged(index: Int, score: Int) {
        (data[index] as ScoreQuestionDto).score = score
    }

}