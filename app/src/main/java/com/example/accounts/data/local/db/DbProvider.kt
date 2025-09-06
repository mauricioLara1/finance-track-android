/**
 * (4) DB PROVIDER (Singleton):
 * - Entrega UNA sola instancia de AppDatabase para toda la app.
 * - Usa applicationContext (evita leaks de Activity).
 */
package com.example.accounts.data.local.db

import android.content.Context
import androidx.room.Room

object DbProvider {
    @Volatile private var instance: AppDatabase? = null

    fun get(context: Context): AppDatabase =
        instance ?: synchronized(this) {
            instance ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "finance.db"
            ).build().also { instance = it }
        }
}
