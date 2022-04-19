package com.lost.sqldatabase.room.entites

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserDbEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun userDao():UserDAO
}