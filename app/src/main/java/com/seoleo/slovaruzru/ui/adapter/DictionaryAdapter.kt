package com.seoleo.slovaruzru.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.seoleo.slovaruzru.databinding.LayoutDictionaryBinding
import com.seoleo.slovaruzru.ui.entity.DictionaryModel

class DictionaryAdapter(
    private val dictionaryClicked: (DictionaryModel) -> Unit,
) : RecyclerView.Adapter<DictionaryAdapter.DictionaryViewHolder>() {

    private var items = listOf<DictionaryModel>()

    fun updateList(dictionaries: List<DictionaryModel>) {
        val diffResult  = DiffUtil.calculateDiff(DictionaryDiffUtil(items, dictionaries))
        items = dictionaries
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryViewHolder {
        val dictionaryBinding = LayoutDictionaryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DictionaryViewHolder(dictionaryBinding)
    }

    override fun onBindViewHolder(holder: DictionaryViewHolder, position: Int) {
        holder.set(items[position])
    }

    override fun onBindViewHolder(holder: DictionaryViewHolder, position: Int, payloads: MutableList<Any>) {
        if(payloads.isEmpty()){
            super.onBindViewHolder(holder, position, payloads)
        }else{
            val result = payloads.firstOrNull()
            if(result is DictionaryDiffUtil.DictionaryContentPayload.DefinitionChanged){
                holder.setOpenedState(result.model)
            }
        }
    }

    override fun getItemCount() = items.size

    inner class DictionaryViewHolder(private val dictionaryBinding: LayoutDictionaryBinding) :
        RecyclerView.ViewHolder(dictionaryBinding.root) {

        fun set(model: DictionaryModel) {
            dictionaryBinding.word.text = model.word
            setOpenedState(model)
            dictionaryBinding.definition.text = model.definition
        }

        fun setOpenedState(model: DictionaryModel) {
            dictionaryBinding.definition.isVisible = model.isOpened
            setDictionaryClickedState(model)
        }

        private fun setDictionaryClickedState(model: DictionaryModel) {
            dictionaryBinding.rootLayout.setOnClickListener {
                dictionaryClicked.invoke(model)
            }
        }
    }
}