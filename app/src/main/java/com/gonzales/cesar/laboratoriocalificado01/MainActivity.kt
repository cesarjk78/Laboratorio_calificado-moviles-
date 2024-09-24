package com.gonzales.cesar.laboratoriocalificado01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gonzales.cesar.laboratoriocalificado01.ui.theme.LaboratorioCalificado01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratorioCalificado01Theme {
                // Llama a la función que muestra la interfaz
                InterfazCalculadora()
            }
        }
    }
}

@Composable
fun InterfazCalculadora() {
    // Crear un Box para centrar y rellenar toda la pantalla
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            // Crea una cuadrícula para los botones numéricos
            LazyVerticalGrid(
                columns = GridCells.Fixed(3), // 3 columnas
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp), // Controla la altura total de la cuadrícula
                contentPadding = PaddingValues(8.dp)
            ) {
                val numeros = listOf("7", "8", "9", "4", "5", "6", "1", "2", "3")
                items(numeros) { numero ->
                    BotonCalculadora(numero)
                }
            }

            // Crear la fila de botones especiales
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                BotonCalculadora("<-")
                BotonCalculadora("|")
                BotonCalculadora("->")
            }
        }
    }
}

// Composable para los botones de la calculadora
@Composable
fun BotonCalculadora(texto: String) {
    Button(
        onClick = { /* Acción cuando se presiona el botón */ },
        modifier = Modifier
            .padding(8.dp)
            .size(80.dp) // Asegura que todos los botones tengan el mismo tamaño
    ) {
        Text(text = texto)
    }
}

@Preview(showBackground = true)
@Composable
fun InterfazCalculadoraPreview() {
    LaboratorioCalificado01Theme {
        InterfazCalculadora()
    }
}
