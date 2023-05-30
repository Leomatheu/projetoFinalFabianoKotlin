package com.example.projetofinal.ui.theme


import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projetofinal.viewModel.ListaViagemModel
import com.example.projetofinal.viewModel.ListaViagemViewModel

@Composable
fun telaViagemDisp(onNavigate : (route: String) ->Unit){

    val application = LocalContext.current.applicationContext as Application

    val viewModel: ListaViagemViewModel = viewModel(
        factory = ListaViagemModel (application)
    )

    viewModel.buscarViagens()

    var openDialogRemove by remember { mutableStateOf(false) }

    ConfirmDelete(openDialog = openDialogRemove,
        onRemove = {
            openDialogRemove = false
            viewModel.deleteViagem()
        },
        onClose = { openDialogRemove = false }
    )

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
            modifier = Modifier
                .padding(bottom = 20.dp)
        )

        Spacer(modifier = Modifier.size(10.dp))

        LazyColumn() {
            items(items = viewModel.viagens.value) {

                Card(
                    elevation = 4.dp,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                        .clickable { }
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
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
                                text = "Destino :  ${it.destino}",
                                style = MaterialTheme.typography.h6,
                                textAlign = TextAlign.Start
                            )
                            Text(
                                text = "De ${it.dataInicio} até ${it.dataFim}",
                            )
                            Text(
                                text = "R$ ${it.orcamento}",
                            )
                            Spacer(Modifier.weight(1f))

                        }
                        IconButton(
                            onClick = {
                                viewModel.viagemForDelete = it
                                openDialogRemove = true

                            },
                        ) {
                            Icon(
                                Icons.Default.Delete,
                                contentDescription = "",
                                modifier = Modifier
                                    .weight(1f)
                                    .size(30.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun ConfirmDelete(openDialog: Boolean, onClose: () -> Unit, onRemove: () -> Unit) {
    if (openDialog) {
        AlertDialog(
            onDismissRequest = {
                onClose()
            },
            title = {
                Text(text = "Confirma deletar a viagem")
            },
            text = {
                Column() {
                    Text("Você quer deletar a viagem")
                }
            },
            confirmButton = {
                Button(onClick = { onRemove() }) {
                    Text(text = "Sim")
                }
            },
            dismissButton = {
                Button(onClick = { onClose() }) {
                    Text(text = "Não")
                }
            },
        )
    }
}