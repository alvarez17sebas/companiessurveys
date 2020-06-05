package com.salvarez.companiessurveys.view.adapter.option

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.companiessurveys.model.constant.AdapterEvent
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.model.dto.ScoreOptionDto
import com.salvarez.companiessurveys.view.adapter.option.viewholder.BaseOptionViewHolder
import com.salvarez.companiessurveys.view.factory.ViewHolderOptionFactory

class OptionAdapter : RecyclerView.Adapter<BaseOptionViewHolder>(),
    IViewHolderItemSelected,
    IMixedOptionTextChanged,
    IScoreQuestionTextChanged{

    private var data: MutableList<OptionDto> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseOptionViewHolder {

        return ViewHolderOptionFactory.getViewHolder(parent, viewType, this, this, this)

    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BaseOptionViewHolder, position: Int) {
        var option: OptionDto = data[position]
        holder.drawOptionData(option)
    }

    override fun positionSelected(index: Int, event: Int) {
        when(event){
            AdapterEvent.DELETE_ACTION -> {
                data.removeAt(index)
                notifyItemRemoved(index)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].getOptionType()
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

    override fun textContentChanged(index: Int, text: String) {
        data[index].option = text
        Log.i("option", "scoreOptions: $text")
    }

    override fun textScoreChanged(index: Int, score: Int) {
        (data[index] as ScoreOptionDto).score = score
        Log.i("option", "scoreOptions: $score")
    }


}