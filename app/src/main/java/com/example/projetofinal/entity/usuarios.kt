package com.example.projetofinal.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class usuarios(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val nome : String,
    val usuario : String,
    val senha : String
) {

}