package com.example.projetofinal.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetofinal.entity.Despesas
import com.example.projetofinal.entity.viagem
import com.example.projetofinal.repository.DespesaRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


class RegistroNovaDespesaViewModel (private val despesaRepository: DespesaRepository) : ViewModel()  {

    var data by mutableStateOf("")
    var valor by mutableStateOf("")
    var tipo by mutableStateOf("")
    var descricao by mutableStateOf("")
    var codigoViagem by mutableStateOf("")

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage = _toastMessage.asSharedFlow()


    var despesas: MutableState<List<Despesas>> = mutableStateOf(listOf())
    var despesaForDelete: Despesas? by mutableStateOf(null)

    fun registrarDespesa() {
        viewModelScope.launch {
            val despesa = Despesas(data = data, valor = valor, tipo = tipo, descricao = descricao, codigoViagem = codigoViagem)
            despesaRepository.insereDespesas(despesa)
            _toastMessage.emit("Despesa cadastrada com sucesso !")
        }
    }

    fun buscarDespesas(){
        viewModelScope.launch {
            despesas.value = despesaRepository.buscaDespesas()
        }
    }


    fun deleteDespesa() {
        viewModelScope.launch {
            despesaForDelete?.let {
                despesaRepository.deleteDespesas(it)
                buscarDespesas()
            }
        }
    }



}