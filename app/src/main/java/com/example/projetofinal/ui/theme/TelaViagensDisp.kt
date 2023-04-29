package com.example.projetofinal.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun telaViagemDisp(onNavigate : (route: String) ->Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Viagens Disponíveis",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.size(10.dp))

        Card(elevation = 6.dp) {
            Row(verticalAlignment = Alignment.CenterVertically ) {
                Image(
                    painter = painterResource(com.example.projetofinal.R.drawable.imagem),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .weight(1f)
                        .size(50.dp),
                )
                Column(modifier = Modifier.weight(3f)) {
                    Text(
                        text = "Destino: São Paulo",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "Viagem a lazer",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "Orçamento: R$2000,00",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "Data início: 15/10/2023",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "Data fim: 15/11/2023",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}