package com.lost.sqldatabase.room.entites

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {

    @Query("SELECT * FROM accounts WHERE name = :name")
    fun findAge(name: String): UserDbEntity?

    @Insert
    fun saveName(nameUser:UserDbEntity)

}