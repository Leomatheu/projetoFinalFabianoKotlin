package com.example.projetofinal.dao

import androidx.room.*
import com.example.projetofinal.entity.usuarios
import com.example.projetofinal.entity.viagem

@Dao
interface novaViagemDao {

    @Insert
    suspend fun insert(viagem: viagem)

    @Update
    suspend fun update(viagem: viagem)

    @Delete
    suspend fun delete(viagem: viagem)

    @Query("select * from viagem v order by v.id")
    suspend fun selecionaTodos(): List<viagem>

}