package com.example.projetofinal.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetofinal.dataBase.dataBase
import com.example.projetofinal.repository.userRepository

class LoginViewModelFactory(val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dao = dataBase.getDatabase(application).usuarioDao()
        val userRepository = userRepository(dao)
        return LoginViewModel(userRepository) as T
    }
}