package com.example.trabalho_moblie.ui.theme.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trabalho_moblie.R
import com.example.trabalho_moblie.ui.theme.Brown900
import com.example.trabalho_moblie.ui.theme.Gray900
import com.example.trabalho_moblie.ui.theme.Orange
import com.example.trabalho_moblie.ui.theme.White


@Composable
fun Login(navController: NavController){

    //A TELA COMEÇA AQUI-------------------------------------------------------
    Column(
    //Essa linha garante que a coluna pegue toda a largura X altura da tl
        modifier = Modifier.fillMaxSize()

    //Esse trecho recebe um paramêtro de BackGround com 2 cores
            .background(

                // No fundo, crio brush q recebe uma função que recebe + de 1 cor
                brush = Brush.linearGradient(

                    //Aplico as cores
                    colors = listOf(
                        Gray900,
                        Brown900,
                        Gray900,
                        Gray900
                    )
                )

            //A linha abaixo garante que terá uma barra de rolagem na coluna, caso a img fique grande.
            ).verticalScroll(rememberScrollState()),

            //Garantindo que todos os elementos da coluna estejam alinhados em X e Y
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

    ) {

        //FOTO DO FUNDO-----------------------------------------------------------
        //Agora no topo da coluna, usamos o componente image
        Image(

            //Para imagens locais, usamos o painter
                        //O drawble busca a imagem local, quando import o R
                                //Precisa ser o R do projeto (passar o mouse em cima)
            painter = painterResource(id = R.drawable.logo),

            //Só irá aparecer a imagem após darmos uma descrição pra ela
            contentDescription = "imagem de fundo da tela de login",

            //Através do modificador desta imagem, vou configurar o size dela
            modifier = Modifier.width(400.dp).height(420.dp),

            //Essa var recebe uma função que expande e recorta a imagem
            contentScale = ContentScale.Crop,

            //Alinhando ao centro
            alignment = Alignment.Center


        )
        //ACABA A FOTO DO FUNDO ----------------------------------------------------
        //Ainda dentro da coluna tela

        //TEXTO INTRUDUTÓRIO--------------------------------------------------------
        Text(

            //Texto possui palavras com cores diferentes, preciso da função build do componente texto.
            text = buildAnnotatedString {

                //Branco
                append("Seja bem-vindo! Prepare-se para saborear")

                //Se torna laranja
                withStyle(
                    style = SpanStyle(color = Orange)
                ){
                    //Texto com a cor alterada dentro do withStyle
                    append(" pizzas \nincríveis")

                }

                append(" com entrega rápida")

                //Volta para a cor original do componente text
            },
            color = White, //Cor do texto
            fontSize = 25.sp, //Tamanho do texto
            fontWeight = FontWeight.Bold, //Negrito
            modifier = Modifier.fillMaxSize().padding(20.dp)
        )

        //2° TEXTO "H2"
        Text(
            text = "Com um simples clique, sua pizza quentinha chega até você em minutos.",
            color = White, //Cor do texto
            fontSize = 16.sp, //Tamanho do texto
            modifier = Modifier.fillMaxSize().padding(20.dp, 20.dp, 20.dp, 30.dp)
        )
        //FIM DOS TEXTOS H1 E H2------------------------------------------------------

        //BOTÕES (FOOTER)-------------------------------------------------------------
        Row(
            //Configurando a linha
            modifier = Modifier.fillMaxWidth(),

            //Dando espaçamento entre os 2 botões existentes na linha
            horizontalArrangement = Arrangement.SpaceAround

        ) {

            //Criando o 1° botão
            Button(
                onClick = {
                    // Navega para a tela do cardápio
                    navController.navigate("cardapio")
                },

                //No parâmentro colors do botão, chamo a função "padrões do botão"
                                        //Que chama a função cores do botão
                colors = ButtonDefaults.buttonColors(

                    //A função cores do botão possuí um parâmetro chamado "cor do container"
                            //Que recebe a cor:
                    containerColor = Color.Transparent
                ),

                //Configuro a borda do botão
                border = BorderStroke(
                    width = 1.dp, //Largura da borda
                    color = White,

                )
            ){
                //Configuações do texto do botão
                Text(
                    text = "Cardápio",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = White
                )
            }

            //Criando o 2° botão
            Button(
                onClick ={ },

                //No parâmentro colors do botão, chamo a função "padrões do botão"
                //Que chama a função cores do botão
                colors = ButtonDefaults.buttonColors(

                    //A função cores do botão possuí um parâmetro chamado "cor do container"
                    //Que recebe a cor:
                    containerColor = Orange,
                ),

                //Aplicando sombra no botão
                modifier = Modifier.shadow(
                    elevation = 16.dp,
                    shape = CircleShape,
                    spotColor = Orange
                )

            ){
                //Configuações do texto do botão
                Text(
                    text = "Whats App",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = White
                )
            }
        }
    }

}

