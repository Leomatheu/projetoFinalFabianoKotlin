package com.example.projetofinal.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class viagem(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val destino : String,
    val dataInicio : String,
    val dataFim : String,
    val orcamento : String
) {

}