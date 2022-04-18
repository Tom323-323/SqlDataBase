package com.lost.sqldatabase.room.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "accounts",
    indices = [
        Index("email", unique = true)
    ])
data class UserDbEntity {
    @PrimaryKey(autoGenerate = true) val id: Long,
            @ColumnInfo(collate = ColumnInfo.NOCASE) val email: String,val user: String, val password: String)


}