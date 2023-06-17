package com.example.projetofinal.repository

import com.example.projetofinal.dao.DespesasDao
import com.example.projetofinal.entity.Despesas
import com.example.projetofinal.entity.usuarios
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DespesaRepository(private val DespesasDao : DespesasDao) {

    private val coroutine = CoroutineScope(Dispatchers.Main)

    fun insereDespesas(despesas : Despesas) {
        coroutine.launch(Dispatchers.IO) {
            DespesasDao.insert(despesas)
        }

    }

    fun deleteDespesas(despesas: Despesas){
        coroutine.launch(Dispatchers.IO) {
            DespesasDao.delete(despesas)
        }
    }

    suspend fun buscaDespesas(): List<Despesas> {
        return DespesasDao.selecionaTodas()
    }
}