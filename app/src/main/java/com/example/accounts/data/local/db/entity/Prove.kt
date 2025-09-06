package com.example.accounts.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "probe")
data class Probe(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val value: String
)
