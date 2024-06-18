package com.seoleo.slovaruzru.ui.touzb

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seoleo.slovaruzru.App
import com.seoleo.slovaruzru.ui.entity.DictionaryModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ToUzbViewModel : ViewModel() {

    val dictionariesStateFlow = MutableStateFlow<List<DictionaryModel>>(emptyList())

    init {
        initDictionaries()
    }

    private fun initDictionaries() {
        viewModelScope.launch(Dispatchers.IO) {
            App.db.toUzbDao().getAll().let { fromRusEntities ->
                dictionariesStateFlow.value = fromRusEntities.map {
                    DictionaryModel(
                        id = it.id,
                        word = it.word ?: "",
                        definition = it.definition ?: "",
                        isOpened = false
                    )
                }
            }
        }
    }

    fun dictionaryClicked(dictionaryModel: DictionaryModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val dictionaries = dictionariesStateFlow.value.toMutableList()
            val updateModel = dictionaries[dictionaryModel.id - 1]
            dictionaries[dictionaryModel.id - 1] = updateModel.copy(isOpened = !dictionaryModel.isOpened)
            dictionariesStateFlow.value = dictionaries
        }
    }


    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared")
    }



    companion object {
        private const val TAG = "ToUzbViewModel"
    }
}