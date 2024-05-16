package com.example.dbtry.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(nameEntity: NameEntity)

    @Delete
    suspend fun deleteItem(nameEntity: NameEntity)

    @Query("SELECT * FROM notes")
    fun getAllItems(): Flow<List<NameEntity>>
}