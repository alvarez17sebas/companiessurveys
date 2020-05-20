package com.salvarez.companiessurveys.view.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.constant.AdapterEvent
import com.salvarez.companiessurveys.model.dto.OptionDto

class OptionViewHolder(itemView: View, var viewHolderItemSelected: IViewHolderItemSelected, var textChanged: ITextChanged) : RecyclerView.ViewHolder(itemView) {

    var etMixedQuestionOption: TextInputEditText = itemView.findViewById(R.id.etMixedQuestionOptionItemCreate)
    var ivDeleteMixedQuestionOption: ImageView = itemView.findViewById(R.id.ivDeleteMixedQuestionItemCreate)
    var etMixedQuestionOptionItemCreate: TextInputEditText = itemView.findViewById(R.id.etMixedQuestionOptionItemCreate)

    init {
        clickListenerBehaviors()
    }

    private fun clickListenerBehaviors(){
        ivDeleteMixedQuestionOption.setOnClickListener {
            viewHolderItemSelected.positionSelected(layoutPosition, AdapterEvent.DELETE_ACTION)
        }
        etMixedQuestionOptionItemCreate.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                textChanged.textChanged(layoutPosition, s.toString())
            }

        })

    }

    fun drawData(option: OptionDto){
        etMixedQuestionOption.setText(option.option)
    }
}