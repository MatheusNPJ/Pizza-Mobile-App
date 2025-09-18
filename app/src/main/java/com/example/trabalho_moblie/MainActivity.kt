package com.example.trabalho_moblie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.trabalho_moblie.ui.theme.views.Cardapio
import com.example.trabalho_moblie.ui.theme.views.Index
import com.example.trabalho_moblie.ui.theme.views.Login
import com.example.trabalho_moblie.ui.theme.views.Sessao


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            //Aqui temos o INDEX que realiza o fluxo com NavController (o controlador)
            val navController = rememberNavController()

            //O NaHost é como o navegador, ele que obedece o controlador, e mostra o que o contralor mandar
                                                    //setado com padrão de página login
            NavHost(navController = navController, startDestination = "Index"){

                //Orientado, quando a rota for login, mostrar o composable "login"
                composable ("Index"){
                    Index(navController)
                }

                //Quando no login, clicarem em cardápio, o botão cardápio através do navController.navigate("cardapio")
                //vem até o main e encontra a rota chamada Cardapio que essa rota chama o composable Cardapio.
                composable("Cardapio") {
                    Cardapio(navController)
                }

                composable("Login") {
                    Login(navController)
                }

                composable(
                    "Sessao/{nome}",
                    arguments = listOf(navArgument("nome"){type = NavType.StringType})
                ) {
                    //backStackEntry.arguments é onde ficam todos os argumentos passados pela rota.
                    backStackEntry ->
                    val nome = backStackEntry.arguments?.getString("nome")

                    Sessao(navController, nome = nome)
                }
            }

        }
    }
}

