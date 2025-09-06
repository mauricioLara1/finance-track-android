/**
 * (5) VIEWMODEL: Lógica/estado de la pantalla.
 * - Recibe DAO.
 * - Expone estado listo para la UI (StateFlow).
 * - Ejecuta inserciones con viewModelScope.
 */
package com.example.accounts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.accounts.data.local.db.dao.ProbeDao
import com.example.accounts.data.local.db.entity.Probe
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProbeViewModel(private val dao: ProbeDao) : ViewModel() {

    // Lista observable (UI se actualiza sola)
    val probes = dao.getAll()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun add(value: String) {
        if (value.isBlank()) return
        viewModelScope.launch {
            dao.insert(Probe(value = value.trim()))
        }
    }
}
