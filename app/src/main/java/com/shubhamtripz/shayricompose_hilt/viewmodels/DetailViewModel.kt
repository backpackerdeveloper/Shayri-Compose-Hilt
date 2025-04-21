package com.shubhamtripz.shayricompose_hilt.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhamtripz.shayricompose_hilt.models.ShayriItem
import com.shubhamtripz.shayricompose_hilt.repository.ShayriRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel@Inject constructor(private val repository: ShayriRepository) : ViewModel() {

    val shayri: StateFlow<List<ShayriItem>>
        get() = repository.shayris

    init {
        viewModelScope.launch {
            repository.getShayris("love")
        }
    }
}