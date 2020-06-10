package com.salvarez.companiessurveys.view.adapter.option

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.companiessurveys.model.dto.OptionDto
import com.salvarez.companiessurveys.view.adapter.option.viewholder.BaseOptionViewHolder
import com.salvarez.companiessurveys.view.factory.ViewHolderOptionFactory

class OptionAdapter : RecyclerView.Adapter<BaseOptionViewHolder>(),
    IMixedOptionTextChanged{

    private var data: MutableList<OptionDto> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseOptionViewHolder {

        return ViewHolderOptionFactory.getViewHolder(parent, viewType, ViewHolderOptionSelectedImpl(data, this), this)

    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BaseOptionViewHolder, position: Int) {
        var option: OptionDto = data[position]
        holder.drawOptionData(option)
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
}