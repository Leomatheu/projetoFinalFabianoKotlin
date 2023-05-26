package com.example.projetofinal.repository

import com.example.projetofinal.dao.usuarioDao
import com.example.projetofinal.entity.usuarios
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class userRepository(private val usuarioDao: usuarioDao) {

    private val coroutine = CoroutineScope(Dispatchers.Main)

    fun insereUsuario(usuarios: usuarios) {
        coroutine.launch(Dispatchers.IO) {
            usuarioDao.insert(usuarios)
        }

    }

    fun deleteUsuario(usuarios: usuarios){
        coroutine.launch(Dispatchers.IO) {
            usuarioDao.delete(usuarios)
        }
    }

    suspend fun buscaUsuario(): List<usuarios> {
        return usuarioDao.selecionaTodos()
    }

    suspend fun buscaPorNome(nome: String): usuarios? =
        usuarioDao.selecionaNome(nome)
}