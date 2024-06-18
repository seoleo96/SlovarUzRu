package com.seoleo.slovaruzru.ui.entity

data class DictionaryModel(
    val id: Int = 0,
    val word: String,
    val definition: String,
    val isOpened : Boolean
)