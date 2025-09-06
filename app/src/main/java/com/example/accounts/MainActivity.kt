/**
 * (8) ACTIVITY (Host):
 * - Ciclo de vida / tema.
 * - Crea el ViewModel con Factory.
 * - Muestra la pantalla (ProbeScreen).
 */
package com.example.accounts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.accounts.ui.theme.AccountsTheme
import com.example.accounts.ui.screens.ProbeScreen
import com.example.accounts.viewmodel.ProbeViewModel
import com.example.accounts.viewmodel.ProbeViewModelFactory

class MainActivity : ComponentActivity() {

    private val vm: ProbeViewModel by viewModels {
        ProbeViewModelFactory(applicationContext) // inyecta dao vía DbProvider
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AccountsTheme {
                ProbeScreen(vm) // MainActivity solo hostea la pantalla
            }
        }
    }
}
