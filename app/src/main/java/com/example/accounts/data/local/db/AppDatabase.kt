/**
 * (3) ROOM DATABASE:
 * - Registra entities y expone DAOs.
 * - Cambios de esquema => subir 'version' y definir migraciones.
 */
package com.example.accounts.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase

//Dao, consultas
import com.example.accounts.data.local.db.dao.ProbeDao
//entity, modelo de tabla
import com.example.accounts.data.local.db.entity.Probe

//el @ database crea la base de datos? entiendo que nomas aqui es donde se une el dao y la bd
@Database(
    entities = [Probe::class],
    version = 1,
    exportSchema = true
)

//aqui nc
abstract class AppDatabase : RoomDatabase() {
    abstract fun probeDao(): ProbeDao
}
