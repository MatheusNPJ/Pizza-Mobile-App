package com.example.trabalho_moblie.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.trabalho_moblie.data.repository.UserRepository
import com.example.trabalho_moblie.ui.theme.Black
import com.example.trabalho_moblie.ui.theme.Orange
import com.example.trabalho_moblie.ui.theme.White
import com.example.trabalho_moblie.ui.viewmodels.UserViewModel
import com.example.trabalho_moblie.ui.viewmodels.UserViewModelFactory


@Composable
//O composable Cardápio, recebe como parâmetro um dado do tipo navController
//Chamado NavController, que no main está configurado a chamar Cardápio
fun SessaoScreen(navController: NavController, userName : String){

    val context = LocalContext.current

    val viewModel: UserViewModel = viewModel(
        factory = UserViewModelFactory(
            UserRepository(
                AppDatabase.getDatabase(context).userDao()
            )
        )
    )

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column (
        modifier = Modifier.fillMaxSize()
            .background(
                color = White

                //A linha abaixo garante que terá uma barra de rolagem na coluna, caso a img fique grande.
            ).verticalScroll(rememberScrollState()),

        //Garantindo que todos os elementos da coluna estejam alinhados em X e Y
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Card (
            modifier = Modifier.padding(20.dp).padding(top = 40.dp),
            colors = CardDefaults.cardColors(
                containerColor = Orange
            )
        ){
            Column(
                modifier = Modifier.fillMaxWidth().padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text ="Sr(a) $userName você está logado! ",
                    color = White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

            }
        }

        Row(
            modifier = Modifier
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround,  // ← Centraliza horizontalmente
            verticalAlignment = Alignment.CenterVertically  // ← Alinha verticalmente

        )
        {
            botao(navController = navController, name = "Editar")
            botao(navController = navController, name = "Sair")
        }
        CardapioScreen(navController = navController)

    }
    }


@Composable
fun botao(navController : NavController, name : String) {
//Criando o 1° botão
    Button(
        onClick = {
            // Navega para a tela do cardápio
            navController.navigate("")
        },

        //No parâmentro colors do botão, chamo a função "padrões do botão"
        //Que chama a função cores do botão
        colors = ButtonDefaults.buttonColors(

            //A função cores do botão possuí um parâmetro chamado "cor do container"
            //Que recebe a cor:
            containerColor = Color.Gray
        ),

        //Configuro a borda do botão
        border = BorderStroke(
            width = 1.dp, //Largura da borda
            color = White,

            )
    ) {
        //Configuações do texto do botão
        Text(
            text = name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = White
        )
    }
}