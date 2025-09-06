package com.example.accounts.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.accounts.data.local.db.entity.Probe
import kotlinx.coroutines.flow.Flow

@Dao
interface ProbeDao {
    @Insert
    suspend fun insert(probe: Probe): Long

    @Query("SELECT * FROM probe ORDER BY id ASC")
    fun getAll(): Flow<List<Probe>>
}
