/**
 * (2) DAO: API de acceso a datos (SQL).
 * - No conoce UI ni estados, solo I/O.
 * - Devuelve Flow para observar cambios en tiempo real.
 */
package com.example.accounts.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.accounts.data.local.db.entity.Probe
import kotlinx.coroutines.flow.Flow

//Data Acess Objt
//estos archivos son los que contienen las consultas
//porque es interface?

@Dao
interface ProbeDao {
    @Insert
    suspend fun insert(probe: Probe): Long

    @Query("SELECT * FROM probe ORDER BY id ASC")
    fun getAll(): Flow<List<Probe>>
}
