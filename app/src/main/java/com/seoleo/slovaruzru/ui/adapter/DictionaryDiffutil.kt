package com.seoleo.slovaruzru.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.seoleo.slovaruzru.ui.entity.DictionaryModel

class DictionaryDiffUtil(
    private val oldList: List<DictionaryModel>,
    private val newList: List<DictionaryModel>,
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
//        val oldModel = oldList[oldItemPosition]
//        val newModel = newList[newItemPosition]
//        return oldModel.id == newModel.id &&
//                oldModel.word == newModel.word &&
//                oldModel.definition == newModel.definition &&
//                oldModel.isOpened == newModel.isOpened
    }
}