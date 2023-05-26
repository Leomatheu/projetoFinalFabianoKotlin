package com.example.projetofinal.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.projetofinal.entity.usuarios

@Dao
interface usuarioDao {

    @Insert
    suspend fun insert(usuario: usuarios)

    @Update
    suspend fun update(usuario: usuarios)

    @Delete
    suspend fun delete(usuario: usuarios)

    @Query("select * from usuarios u order by u.nome")
    suspend fun selecionaTodos(): List<usuarios>

    @Query("select * from usuarios u where u.nome = :name")
    suspend fun selecionaNome(name : String) : usuarios?
}