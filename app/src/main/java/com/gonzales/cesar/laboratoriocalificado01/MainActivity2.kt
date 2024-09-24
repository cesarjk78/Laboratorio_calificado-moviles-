package com.gonzales.cesar.laboratoriocalificado01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gonzales.cesar.laboratoriocalificado01.ui.theme.LaboratorioCalificado01Theme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratorioCalificado01Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Puedes cambiar la palabra para el segundo MainActivity
                    val palabra = "world"
                    val frecuencia = contarFrecuencia(palabra)

                    // Convertimos el resultado a un formato de texto para mostrarlo
                    val resultado = "Frecuencia de caracteres en '$palabra': $frecuencia"

                    // Mostramos el resultado en la interfaz de usuario
                    Greeting(
                        name = resultado,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Puedes mantener la misma función contarFrecuencia
fun contarFrecuencia(palabra: String): Map<Char, Int> {
    val frecuencia = mutableMapOf<Char, Int>()
    for (char in palabra) {
        frecuencia[char] = frecuencia.getOrDefault(char, 0) + 1
    }
    return frecuencia
}

// Composable que recibe el texto con el resultado y lo muestra en la interfaz
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LaboratorioCalificado01Theme {
        Greeting("Hello World!")
    }
}