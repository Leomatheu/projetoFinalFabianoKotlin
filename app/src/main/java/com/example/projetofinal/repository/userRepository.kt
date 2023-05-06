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
}