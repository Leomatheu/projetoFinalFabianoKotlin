package com.example.projetofinal.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetofinal.entity.viagem
import com.example.projetofinal.repository.viagemRepository
import kotlinx.coroutines.launch

class ListaViagemViewModel(private val viagemRepository: viagemRepository): ViewModel()  {
    var viagens: MutableState<List<viagem>> = mutableStateOf(listOf())

    var showDialogDelete = mutableStateOf(false)

    var viagemForDelete: viagem? by mutableStateOf(null)

    fun buscarViagens(){
        viewModelScope.launch {
            viagens.value = viagemRepository.buscaViagens()
        }
    }

    fun deleteViagem() {
        viewModelScope.launch {
            viagemForDelete?.let {
                viagemRepository.deletaViagem(it)
                buscarViagens()
            }
        }
    }
}