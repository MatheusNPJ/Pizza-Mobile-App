package com.example.trabalho_moblie.ui.theme.views
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trabalho_moblie.R
import com.example.trabalho_moblie.ui.theme.Orange
import com.example.trabalho_moblie.ui.theme.White


@Composable
fun Login(navController: NavController){
    val context = LocalContext.current
    Column(
    modifier = Modifier
        .fillMaxSize()
        .background(
            color = White

            //A linha abaixo garante que terá uma barra de rolagem na coluna, caso a img fique grande.
        )
        .verticalScroll(rememberScrollState())
        .background(
            color = White
        ),

    //Garantindo que todos os elementos da coluna estejam alinhados em X e Y
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(

            //Para imagens locais, usamos o painter
            //O drawble busca a imagem local, quando import o R
            //Precisa ser o R do projeto (passar o mouse em cima)
            painter = painterResource(id = R.drawable.logo),

            //Só irá aparecer a imagem após darmos uma descrição pra ela
            contentDescription = "imagem de fundo da tela de login",

            //Através do modificador desta imagem, vou configurar o size dela
            modifier = Modifier
                .width(400.dp)
                .height(420.dp),

            //Essa var recebe uma função que expande e recorta a imagem
            contentScale = ContentScale.Crop,

            //Alinhando ao centro
            alignment = Alignment.Center
        )

        FormularioSimples(navController)
        }
    }

data class Acesso(
    val login : String,
    val senha : String
    )

val acessos = listOf(
    Acesso("admin", "123")
)



@Composable
fun FormularioSimples(navController: NavController) {
    val laranja = Color(0xFFFF9800)


    var nome by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(24.dp)
            .background(
                color = White
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        // Campo Nome
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            // A função de cores para o Material 2 usa o mesmo nome,
            // mas pertence à biblioteca material (sem o "3").

            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        // Campo Email
        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        val context = LocalContext.current

        // Botão de Enviar
        Button(

            colors = ButtonDefaults.buttonColors(

                //A função cores do botão possuí um parâmetro chamado "cor do container"
                //Que recebe a cor:
                containerColor = Orange,
            ),

            onClick = {

                if (nome == acessos[0].login && senha == acessos[0].senha) {

                    navController.navigate("Sessao/$nome")

                }else{

                    Toast.makeText(context, "Login ou senha incorretos", Toast.LENGTH_SHORT).show()
                }

            }, //Aplicando sombra no botão
            modifier = Modifier.shadow(
                elevation = 16.dp,
                shape = CircleShape,
                spotColor = Orange
            )
        ) {
            Text("Enviar")
        }
    }
}


