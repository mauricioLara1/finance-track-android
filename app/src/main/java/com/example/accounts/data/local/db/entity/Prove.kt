package com.example.accounts.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
/**
 * (1) ENTITY: Molde de la tabla SQLite manejada por Room.
 * - Define columnas y PK.
 * - Room genera CREATE TABLE IF NOT EXISTS cuando se crea/abre la DB.
 */

@Entity(tableName = "probe")
data class Probe(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val value: String
)
