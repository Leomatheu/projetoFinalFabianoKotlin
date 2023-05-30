package com.example.projetofinal.viewModel

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetofinal.repository.userRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


class LoginViewModel(private val userRepository: userRepository) : ViewModel() {
    var nome by mutableStateOf("")
    var senha by mutableStateOf("")

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage = _toastMessage.asSharedFlow()


    fun validateLogin(onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val usuario = userRepository.buscaPorNome(nome)
            val result = usuario != null && usuario.senha == senha

            onResult(result)
            if (!result )
                _toastMessage.emit("Login inválido !")
        }
    }
}