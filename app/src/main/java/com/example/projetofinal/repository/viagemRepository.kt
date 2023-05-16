package com.example.projetofinal.repository

import com.example.projetofinal.dao.novaViagemDao
import com.example.projetofinal.entity.viagem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class viagemRepository(private val novaViagemDao: novaViagemDao) {

    private val coroutine = CoroutineScope(Dispatchers.Main)

    fun insereViagem(viagem: viagem) {
        coroutine.launch(Dispatchers.IO) {
            novaViagemDao.insert(viagem)
        }
    }

    fun deletaViagem(viagem: viagem) {
        coroutine.launch(Dispatchers.IO) {
            novaViagemDao.delete(viagem)
        }
    }

    suspend fun buscaViagens() : List<viagem>{
        return novaViagemDao.selecionaTodos()
    }
}