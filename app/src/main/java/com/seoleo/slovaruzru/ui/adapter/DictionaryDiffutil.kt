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
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val oldModel = oldList[oldItemPosition]
        val newModel = newList[newItemPosition]
        return when {
            oldModel.isOpened != newModel.isOpened -> {
                DictionaryContentPayload.DefinitionChanged(newModel)
            }

            else -> null
        }
    }

    sealed class DictionaryContentPayload{
        class DefinitionChanged(val model : DictionaryModel)
    }
}