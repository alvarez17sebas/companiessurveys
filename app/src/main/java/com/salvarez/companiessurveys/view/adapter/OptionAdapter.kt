package com.salvarez.companiessurveys.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.constant.AdapterEvent
import com.salvarez.companiessurveys.model.dto.OptionDto

class OptionAdapter : RecyclerView.Adapter<OptionViewHolder>(), IViewHolderItemSelected, ITextChanged {

    private var data: MutableList<OptionDto> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        return OptionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_mixed_question_option_create, parent, false), this, this)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        var option: OptionDto = data[position]
        holder.drawData(option)
    }

    override fun positionSelected(index: Int, event: Int) {
        when(event){
            AdapterEvent.DELETE_ACTION -> {
                data.removeAt(index)
                notifyItemRemoved(index)
            }
        }
    }

    override fun textChanged(index: Int, text: String) {
        data[index].option = text
    }

    fun getAdapterContent(): MutableList<OptionDto>{
        return data
    }

    fun addOption(option: OptionDto){
        option.idOption = System.currentTimeMillis().toInt()
        data.add(option)
        notifyItemInserted(data.size - 1)
    }


}