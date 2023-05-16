package com.example.projetofinal.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetofinal.dataBase.dataBase
import com.example.projetofinal.repository.viagemRepository

class RegistroNovaViagemViewModelfactory(val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dao =  dataBase.getDatabase(application).novaViagemDao()
        val viagemRepository = viagemRepository(dao)
        return RegistroNovaViagemViewModel(viagemRepository) as T
    }
}