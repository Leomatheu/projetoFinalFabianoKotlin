package com.example.projetofinal.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetofinal.entity.usuarios
import com.example.projetofinal.entity.viagem
import com.example.projetofinal.repository.viagemRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class RegistroNovaViagemViewModel(private val viagemRepository: viagemRepository) : ViewModel() {

    var destino by mutableStateOf("")
    var dataInicio by mutableStateOf("")
    var dataFim by mutableStateOf("")
    var orcamento by mutableStateOf("")

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage = _toastMessage.asSharedFlow()

    var validaViagem by mutableStateOf(true)


    private fun validaFields() {
        validaViagem = destino.isNotEmpty()

        if (!validaViagem) {
            throw Exception("Viagem não cadastrada !")
        }
    }

    fun registrar() {
        viewModelScope.launch {
            val viagem = viagem(destino = destino, dataInicio = dataInicio, dataFim = dataFim, orcamento = orcamento)
            viagemRepository.insereViagem(viagem)
            _toastMessage.emit("Viagem cadastrada com sucesso !")
        }
    }
}