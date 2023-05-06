package com.example.projetofinal.viewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.projetofinal.entity.usuarios
import com.example.projetofinal.repository.userRepository


class RegistroNovoUsuarioViewModel(private val userRepository: userRepository) : ViewModel() {

    var Novousuario by mutableStateOf("")
    var novoNome by mutableStateOf("")
    var Novasenha by mutableStateOf("")

    fun registrar() {
        val novoUsuario = usuarios(nome = novoNome, usuario = Novousuario, senha = Novasenha)

        userRepository.insereUsuario(novoUsuario)
    }
}