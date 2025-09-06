/**
 * (7) UI SCREEN (Compose):
 * - Dibuja la pantalla (input + botón + lista).
 * - Observa vm.probes y llama vm.add().
 * - Sin SQL ni lógica de datos aquí.
 */
package com.example.accounts.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.accounts.viewmodel.ProbeViewModel

@Composable
fun ProbeScreen(vm: ProbeViewModel) {
    val probes by vm.probes.collectAsState()

    var text by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold { inner ->
        Column(
            Modifier
                .padding(inner)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text("Probe table demo", style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(12.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("New value") },
                    singleLine = true
                )
                Button(
                    onClick = {
                        vm.add(text.text)
                        text = TextFieldValue("")
                    }
                ) { Text("Add") }
            }

            Spacer(Modifier.height(16.dp))
            Divider()
            Spacer(Modifier.height(8.dp))

            LazyColumn(Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                items(probes) { item ->
                    ListItem(
                        headlineContent = { Text(item.value) },
                        supportingContent = { Text("id = ${item.id}") }
                    )
                    Divider()
                }
            }
        }
    }
}