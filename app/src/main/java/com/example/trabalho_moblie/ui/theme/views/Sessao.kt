package com.example.trabalho_moblie.ui.theme.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trabalho_moblie.ui.theme.Orange


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sessao(NavController: NavController, nome: String?) {

    Scaffold(
        topBar = { TopAppBar(title = { Text("Acesso Restrito") }) }
    ) { padding ->
        Card(
            modifier = Modifier
                .padding(padding).fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF1E88E5) // azul moderno
            )

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Ícone redondo
                Surface(
                    modifier = Modifier.size(65.dp),
                    shape = CircleShape,
                    color = Orange
                ) {
                    Icon(
                        imageVector = Icons.Default.Lock, // exemplo de ícone
                        contentDescription = "Ícone de Acesso",
                        tint = Color.White,
                        modifier = Modifier.padding(12.dp) // espaço interno do ícone
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier
                        .padding(padding)
                ) {

                    Text(
                        text = "Sr. $nome",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Seja Bem-Vindo!",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }
        }

    }
}