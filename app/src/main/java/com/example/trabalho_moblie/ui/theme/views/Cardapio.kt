package com.example.trabalho_moblie.ui.theme.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trabalho_moblie.ui.theme.Gray100
import com.example.trabalho_moblie.ui.theme.Gray900
import com.example.trabalho_moblie.ui.theme.Orange
import com.example.trabalho_moblie.ui.theme.White


@Composable
//O composable Cardápio, recebe como parâmetro um dado do tipo navController
//Chamado NavController, que no main está configurado a chamar Cardápio
fun Cardapio(navController: NavController){

    Column (
        modifier = Modifier.fillMaxSize()
            .background(
                color = White

                //A linha abaixo garante que terá uma barra de rolagem na coluna, caso a img fique grande.
            ).verticalScroll(rememberScrollState()),

            //Garantindo que todos os elementos da coluna estejam alinhados em X e Y
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

        Text(
            text = "Cardápio",
            fontSize = 30.sp,
            color = Gray900,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp)
        )

        Titulos("Tradicionais")

        CabecalhoPizzas()

        //Aqui chamo a fun Items, que percorre lista, e leva um classificador, que classifica se imprime ou não
        Items(listItemsCardapio, 1)

        Titulos("Especiais")

        CabecalhoPizzas()

        Items(listItemsCardapio, 2)


        Titulos("Doces")

        CabecalhoPizzas()

        Items(listItemsCardapio, 3)

        Titulos("Bebidas")

        CabecalhoBebidas()

        Items(listItemsCardapio, 4)

    }
}

//Estrutura do dado item
data class Item(
    val sabor : String,
    val precoP : Float,
    val precoM : Float,
    val precoG : Float,

    //1 - tradicional / 2 - Especiais / 3 - Doces / 4 - Bebidas
    val classificacao : Int
)

//Criando a lista de items
val listItemsCardapio = listOf(

        Item("4 Queijos", 30f, 37f, 50f, 1),
        Item("Calabresa", 28f, 35f, 48f, 1),
        Item("Mussarela", 27f, 34f, 46f, 1),
        Item("4 Queijos", 30f, 37f, 50f, 1),
        Item("Calabresa", 28f, 35f, 48f, 1),
        Item("Mussarela", 27f, 34f, 46f, 1),
        Item("4 Queijos", 30f, 37f, 50f, 1),
        Item("Calabresa", 28f, 35f, 48f, 1),
        Item("Mussarela", 27f, 34f, 46f, 1),

        Item("Portuguesa", 32f, 39f, 52f, 2),
        Item("Frango com Catupiry", 33f, 40f, 55f, 2),
        Item("Portuguesa", 32f, 39f, 52f, 2),
        Item("Frango com Catupiry", 33f, 40f, 55f, 2),
        Item("Portuguesa", 32f, 39f, 52f, 2),
        Item("Frango com Catupiry", 33f, 40f, 55f, 2),


        Item("Chocolate", 25f, 30f, 38f, 3),
        Item("Chocolate", 25f, 30f, 38f, 3),
        Item("Chocolate", 25f, 30f, 38f, 3),
        Item("Chocolate", 25f, 30f, 38f, 3),
        Item("Chocolate", 25f, 30f, 38f, 3),

        Item("Água 500ml", 3f, 0f, 0f, 4),
        Item("Água 500ml", 3f, 0f, 0f, 4),
        Item("Água 500ml", 3f, 0f, 0f, 4),
        Item("Água 500ml", 3f, 0f, 0f, 4),
        Item("Água 500ml", 3f, 0f, 0f, 4),
        Item("Água 500ml", 3f, 0f, 0f, 4),
        Item("Água 500ml", 3f, 0f, 0f, 4)
    )


//A fun Items, percorre a listItemsCardapio
@Composable
//a var lista, recebe uma lista, composta por ITEM (que é o dataclass que eu estipulei)
fun Items(lista: List<Item>, classificacao: Int) {
    lista.forEach { item ->

        //Se for uma clasificador, de pizza tradicional,  especial ou doce
        //Se eu não fizesse o if por fora, ele renderiza as pizzas com o renderBebidas e duplicava
        //Então, se é pizza, e
        if(item.classificacao == 1 || item.classificacao == 2 || item.classificacao == 3) {

            //É a pizza da modalidade que eu chamei, renderize na formatação renderPizza
            if (item.classificacao == classificacao) {
                renderPizza(item)
            }

        }

        //Se não, é uma bebida
        if(item.classificacao == 4) {
            if (item.classificacao == classificacao) {
                //Renderize na formatação renderBebida
                renderBebida(item)
            }
        }
    }
}

//Render pizza, é a função que determina como é a formatação dos items a serem renderizados quando iterados
@Composable
fun renderPizza(item: Item) {

    //Possui uma linha com 4 colunas, onde cada coluna imprime 1 indice de uma instância Items
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Coluna do Sabor [0]
        Text(
            text = item.sabor,
            modifier = Modifier.weight(2f), // ocupa mais espaço
            textAlign = TextAlign.Start
        )

        // Coluna do Preço P [1]
        Text(
            text = "R$ ${item.precoP}",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Start
        )

        // Coluna do Preço M [2]
        Text(
            text = "R$ ${item.precoM}",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Start
        )

        // Coluna do Preço G [3]
        Text(
            text = "R$ ${item.precoG}",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Start
        )
    }
}


//RenderBebida, função que determina a formatação/estrutura que será renderizado as bebidas
@Composable
fun renderBebida(item : Item) {

    //1 linha e 2 colunas
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Coluna do Sabor [0]
        Text(
            text = item.sabor,
            modifier = Modifier.weight(2f), // ocupa mais espaço
            textAlign = TextAlign.Start
        )

        // Coluna do Preço P [1]
        Text(
            text = "R$ ${item.precoP}",
            modifier = Modifier.weight(3f),
            textAlign = TextAlign.Start
        )

    }
}

@Composable
fun CabecalhoPizzas(){
    //Cabeçalho das instâncias de pizzas tradicionais
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Sabor",
            modifier = Modifier.weight(2f), // ocupa mais espaço
            textAlign = TextAlign.Start,
            fontSize = 20.sp,
            color = Gray100,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "R$ P",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Start,
            fontSize = 20.sp,
            color = Gray100,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "R$ M",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Start,
            fontSize = 20.sp,
            color = Gray100,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "R$ G\n",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Start,
            fontSize = 20.sp,
            color = Gray100,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CabecalhoBebidas(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Coluna do Sabor [0]
        Text(
            text = "Sabor",
            modifier = Modifier.weight(2f), // ocupa mais espaço
            textAlign = TextAlign.Start,
            fontSize = 20.sp,
            color = Gray100,
            fontWeight = FontWeight.Bold
        )

        // Coluna do Preço P [1]
        Text(
            text = "R$",
            modifier = Modifier.weight(3f),
            textAlign = TextAlign.Start,
            fontSize = 20.sp,
            color = Gray100,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun Titulos(titulo : String){
    Text(
        text = "$titulo",
        fontSize = 25.sp,
        color = Orange,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        textAlign = TextAlign.Start
    )

}