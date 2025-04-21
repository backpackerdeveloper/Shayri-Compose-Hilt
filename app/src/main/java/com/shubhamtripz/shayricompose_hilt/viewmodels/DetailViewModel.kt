package com.shubhamtripz.shayricompose_hilt.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhamtripz.shayricompose_hilt.models.ShayriItem
import com.shubhamtripz.shayricompose_hilt.repository.ShayriRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel@Inject constructor(private val repository: ShayriRepository, private val savedStateHandle: SavedStateHandle) : ViewModel() {

    val shayri: StateFlow<List<ShayriItem>>
        get() = repository.shayris

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "motivation"
            repository.getShayris(category)
        }
    }
}