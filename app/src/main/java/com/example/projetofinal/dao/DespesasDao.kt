package com.example.projetofinal.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.projetofinal.entity.Despesas

@Dao
interface DespesasDao {
    @Insert
    suspend fun insert(despesas: Despesas)

    @Update
    suspend fun update(despesas: Despesas)

    @Delete
    suspend fun delete(despesas: Despesas)

    @Query("select * from despesas d order by d.id")
    suspend fun selecionaTodos(): List<Despesas>

    @Query("select * from despesas d where d.id = :id")
    suspend fun selecionaNome(id : String) : Despesas?
}