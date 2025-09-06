/**
 * (6) FACTORY: Cómo crear el ViewModel con dependencias.
 * - Inyecta DAO desde DbProvider sin usar Hilt todavía.
 */
package com.example.accounts.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.accounts.data.local.db.DbProvider

class ProbeViewModelFactory(private val appContext: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val db = DbProvider.get(appContext)
        val dao = db.probeDao()
        @Suppress("UNCHECKED_CAST")
        return ProbeViewModel(dao) as T
    }
}
