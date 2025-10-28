package com.example.trabalho_moblie

import android.R.attr.type
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trabalho_moblie.ui.screens.CadastrarScreen
import com.example.trabalho_moblie.ui.screens.CardapioScreen
import com.example.trabalho_moblie.ui.screens.IndexScreen
import com.example.trabalho_moblie.ui.screens.LoginScreen
import com.example.trabalho_moblie.ui.screens.SessaoScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            //Aqui temos o INDEX que realiza o fluxo com NavController (o controlador)
            val navController = rememberNavController()

            //O NaHost é como o navegador, ele que obedece o controlador, e mostra o que o contralor mandar
                                                    //setado com padrão de página login
            NavHost(navController = navController, startDestination = "IndexScreen"){

                //Orientado, quando a rota for login, mostrar o composable "login"
                composable ("IndexScreen"){
                    IndexScreen(navController)
                }

                //Quando no login, clicarem em cardápio, o botão cardápio através do navController.navigate("cardapio")
                //vem até o main e encontra a rota chamada Cardapio que essa rota chama o composable Cardapio.
                composable("CardapioScreen") {
                    CardapioScreen(navController)
                }

                composable("CadastrarScreen") {
                    CadastrarScreen(navController)
                }

                composable("LoginScreen"){
                    LoginScreen(navController)
                }

                composable("SessaoScreen/{userName}",
                    arguments = listOf(
                        navArgument("userName"){
                            type = NavType.StringType
                        }
                    )
                ){
                        backStackEntry ->
                    val userName = backStackEntry.arguments?.getString("userName") ?: ""
                    SessaoScreen(navController = navController, userName = userName)
                }

            }
        }
    }
}

