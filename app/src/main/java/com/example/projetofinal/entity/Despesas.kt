package com.example.projetofinal.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Despesas(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val data : String,
    val valor : String,
    val tipo : String,
    val descricao : String,
    val codigoViagem : String)
{
}