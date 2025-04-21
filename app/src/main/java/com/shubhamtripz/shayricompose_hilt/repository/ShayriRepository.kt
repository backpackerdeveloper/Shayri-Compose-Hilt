package com.shubhamtripz.shayricompose_hilt.repository

import com.shubhamtripz.shayricompose_hilt.api.ShayriAPI
import com.shubhamtripz.shayricompose_hilt.models.ShayriItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ShayriRepository @Inject constructor(private val shayriAPI: ShayriAPI) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories : StateFlow<List<String>>
    get() = _categories

    private val _shayris = MutableStateFlow<List<ShayriItem>>(emptyList())
    val shayris : StateFlow<List<ShayriItem>>
    get() = _shayris

    suspend fun getCategory(){
        val response = shayriAPI.getCategories()
        if (response.isSuccessful && response.body() != null){
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getShayris(category: String){
        val response = shayriAPI.getShayris("shayri[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null){
            _shayris.emit(response.body()!!)
        }
    }
}