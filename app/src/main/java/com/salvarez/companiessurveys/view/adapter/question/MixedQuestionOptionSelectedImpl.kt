package com.salvarez.companiessurveys.view.adapter.question

import android.util.Log
import com.salvarez.companiessurveys.QuestionType
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.model.dto.QuestionDto

class MixedQuestionOptionSelectedImpl(var data: MutableList<QuestionDto>) : IMixedOptionSelected {

    override fun optionSelected(questionPosition: Int, optionPosition: Int, questionType: Int) {
        var question: QuestionDto = data[questionPosition]
        var option: OptionDto? = question.options?.get(optionPosition)

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

    private fun updateQuestion(positionQuestion: Int, newQuestion: QuestionDto){
        data.removeAt(positionQuestion)
        data.add(positionQuestion, newQuestion)
    }
}