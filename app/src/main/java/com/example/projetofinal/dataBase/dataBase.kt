package com.example.projetofinal.dataBase

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projetofinal.dao.usuarioDao
import com.example.projetofinal.entity.usuarios

@Database(entities = [usuarios::class], version = 1)
abstract class dataBase : RoomDatabase() {

    abstract fun usuarioDao() : usuarioDao

    companion object {
        @Volatile
        private var INSTANCE: dataBase? = null
        fun getDatabase(application: Application): dataBase = INSTANCE ?: synchronized(this){
            val instance = Room.databaseBuilder(
                application,
                dataBase ::class.java,
                "meu-db"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}