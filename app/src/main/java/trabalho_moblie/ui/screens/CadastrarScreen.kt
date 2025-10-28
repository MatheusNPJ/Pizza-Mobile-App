package com.example.trabalho_moblie.ui.screens
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.trabalho_moblie.R
import com.example.trabalho_moblie.data.repository.UserRepository
import com.example.trabalho_moblie.ui.theme.Black
import com.example.trabalho_moblie.ui.theme.Orange
import com.example.trabalho_moblie.ui.theme.White
import com.example.trabalho_moblie.ui.viewmodels.UserViewModel
import com.example.trabalho_moblie.ui.viewmodels.UserViewModelFactory
import kotlinx.coroutines.delay

@Composable
fun CadastrarScreen(navController: NavController) {

    val context = LocalContext.current


    val viewModel: UserViewModel = viewModel(
        factory = UserViewModelFactory(
            UserRepository(
                AppDatabase.getDatabase(context).userDao()
            )
        )
    )


    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    LaunchedEffect(uiState.message) {
        uiState.message?.let { msg ->  // ✅ Agora sim!
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

            if(msg.contains("Usuário cadastrado com sucesso", ignoreCase = true)){
                delay(1500)
                navController.navigate("LoginScreen") {
                    popUpTo("cadastrar") { inclusive = true }
                }
            }
            viewModel.clear_uiState()
        }
    }
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
                ), //CSS

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
                    .width(340.dp)
                    .height(360.dp),

                //Essa var recebe uma função que expande e recorta a imagem
                contentScale = ContentScale.Crop,

                //Alinhando ao centro
                alignment = Alignment.Center,

                )

            //TEXTO DA TELA DE CADASTRO--------------------------------------------------------
            Text(

                //Texto possui palavras com cores diferentes, preciso da função build do componente texto.
                text = buildAnnotatedString {

                    //Branco
                    append("Cadastre-se agora mesmo!\n")

                    //Se torna laranja
                    withStyle(
                        style = SpanStyle(color = Orange)
                    ) {
                        //Texto com a cor alterada dentro do withStyle
                        append("tenha acesso as maravilhas")
                        append("deste mundo!")

                    }
                },
                color = Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                textAlign = TextAlign.Center
            )

            // Campo Nome
            OutlinedTextField(
                value = uiState.name,
                onValueChange = { viewModel.onNomeChange(it) },
                label = { Text("Nome") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp)
                    .padding(horizontal = 10.dp)
            )

            // Campo Senha - ADICIONE ESTE
            OutlinedTextField(
                value = uiState.email,
                onValueChange = { viewModel.onEmailChange(it) },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp)
                    .padding(horizontal = 10.dp)
            )

            // Campo Email
            OutlinedTextField(
                value = uiState.senha,
                onValueChange = { viewModel.onSenhaChange(it) },
                label = { Text("Senha") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp)
                    .padding(horizontal = 10.dp)
            )

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange
                ),
                onClick = {
                    // Chama o ViewModel para cadastrar
                    viewModel.onCadastrar()

                }, //Aplicando sombra no botão
                modifier = Modifier.shadow(
                    elevation = 16.dp,
                    shape = CircleShape,
                    spotColor = Orange
                )
            ) {
                Text(uiState.textoBotao)
            }
        }
    }


