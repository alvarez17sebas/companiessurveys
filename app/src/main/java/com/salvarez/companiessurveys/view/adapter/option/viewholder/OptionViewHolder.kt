package com.salvarez.companiessurveys.view.adapter.option.viewholder

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ImageView
import com.google.android.material.textfield.TextInputEditText
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.constant.AdapterEvent
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.view.adapter.option.IMixedOptionTextChanged
import com.salvarez.companiessurveys.view.adapter.option.IViewHolderItemSelected

class OptionViewHolder(itemView: View, var viewHolderItemSelected: IViewHolderItemSelected, var mixedOptionTextChanged: IMixedOptionTextChanged) : BaseOptionViewHolder(itemView) {

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
                mixedOptionTextChanged.textChanged(layoutPosition, s.toString())
            }

        })

    }

    override fun drawOptionData(option: OptionDto) {
        etMixedQuestionOptionItemCreate.setText(option.option)
    }
}