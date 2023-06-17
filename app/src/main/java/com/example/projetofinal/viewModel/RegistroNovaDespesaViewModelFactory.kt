package com.example.projetofinal.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetofinal.dataBase.dataBase
import com.example.projetofinal.repository.DespesaRepository


class RegistroNovaDespesaViewModelFactory(val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dao =  dataBase.getDatabase(application).DespesasDao()
        val despesa = DespesaRepository(dao)
        return RegistroNovaDespesaViewModel(despesa) as T
    }

}