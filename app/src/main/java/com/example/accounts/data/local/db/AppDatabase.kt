package com.example.accounts.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.accounts.data.local.db.dao.ProbeDao
import com.example.accounts.data.local.db.entity.Probe

@Database(
    entities = [Probe::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun probeDao(): ProbeDao
}
