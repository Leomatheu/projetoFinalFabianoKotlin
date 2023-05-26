package com.example.projetofinal.viewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetofinal.entity.usuarios
import com.example.projetofinal.repository.userRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


class RegistroNovoUsuarioViewModel(private val userRepository: userRepository) : ViewModel() {

    var Novousuario by mutableStateOf("")
    var novoNome by mutableStateOf("")
    var Novasenha by mutableStateOf("")

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage = _toastMessage.asSharedFlow()

    var validaNome by mutableStateOf(true)


    private fun validaFields() {
        validaNome = novoNome.isNotEmpty()

        if (!validaNome) {
            throw Exception("Favor informar um usuário válido !")
        }
    }

    fun registrar() {


        try {
            validaFields()
            val novoUsuario = usuarios(nome = novoNome, usuario = Novousuario, senha = Novasenha)
            userRepository.insereUsuario(novoUsuario)
            /*onSuccess()*/
        } catch (e: Exception) {
            viewModelScope.launch {
                _toastMessage.emit(e.message ?: "Unknown error")
            }
        }
    }
}

