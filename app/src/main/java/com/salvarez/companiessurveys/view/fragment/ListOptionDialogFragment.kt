package com.salvarez.companiessurveys.view.fragment

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.salvarez.companiessurveys.ContentData
import com.salvarez.companiessurveys.R
import com.salvarez.companiessurveys.model.ITypeSelected

class ListOptionDialogFragment(var arrayData: Array<ContentData> , var typeSelected: ITypeSelected) : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(R.string.surveyType)
                .setItems(getArrayFromObject(),
                    DialogInterface.OnClickListener { dialog, index ->
                        typeSelected.typeSelected(getObjectSelected(index).type)
                        dialog.dismiss()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun  getArrayFromObject(): Array<String>{
        var arrayDataStr = Array<String>(arrayData.size) {""}
        for(i in arrayData.indices){
            arrayDataStr[i] = arrayData[i].name
        }
        return arrayDataStr
    }

    private fun getObjectSelected(index: Int): ContentData{
        return arrayData[index]
    }

}