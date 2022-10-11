package com.samuel.lab_10.dataSource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.samuel.lab_10.dataSource.local.dao.CharactersDao
import com.samuel.lab_10.dataSource.local.model.Character

@Database(
    entities = [Character::class],
    version = 1
)
abstract class DataBase : RoomDatabase() {
    abstract fun characterDao(): CharactersDao
}