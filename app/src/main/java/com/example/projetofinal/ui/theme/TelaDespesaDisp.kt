package com.example.projetofinal.ui.theme

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
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
import com.example.projetofinal.R
import com.example.projetofinal.viewModel.ListaViagemModel
import com.example.projetofinal.viewModel.ListaViagemViewModel
import com.example.projetofinal.viewModel.RegistroNovaDespesaViewModel
import com.example.projetofinal.viewModel.RegistroNovaDespesaViewModelFactory

@Composable
fun telaDespesaDisp(){

    val application = LocalContext.current.applicationContext as Application

    val viewModel : RegistroNovaDespesaViewModel = viewModel(
        factory = RegistroNovaDespesaViewModelFactory(application)
    )

    viewModel.buscarDespesas()


    var openDialogRemove by remember { mutableStateOf(false) }

    ConfirmDelete(openDialog = openDialogRemove,
        onRemove = {
            openDialogRemove = false
            viewModel.deleteDespesa()
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
            text = "Despesasas da viagem",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5,
            color = Color.Black,
            modifier = Modifier
                .padding(bottom = 20.dp)
        )

        Spacer(modifier = Modifier.size(10.dp))

        LazyColumn() {
            items(items = viewModel.despesas.value) {

                Card(
                    elevation = 4.dp,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                        .clickable {},

                    ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.imagem),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .weight(1f)
                                .size(50.dp),
                        )
                        Column(modifier = Modifier.weight(3f)) {
                            Text(
                                text = "Data :  ${it.data}",
                                style = MaterialTheme.typography.h6,
                                textAlign = TextAlign.Start
                            )
                            Text(
                                text = "Valor : R$ ${it.valor}",
                            )
                            Text(
                                text = "Tipo : ${it.tipo}",
                            )
                            Text(
                                text = "Descrição : ${it.descricao}",
                            )

                            Spacer(Modifier.weight(1f))

                        }
                        IconButton(
                            onClick = {
                                viewModel.despesaForDelete = it
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
fun ConfirmDeleteDespesa(openDialog: Boolean, onClose: () -> Unit, onRemove: () -> Unit) {
    if (openDialog) {
        AlertDialog(
            onDismissRequest = {
                onClose()
            },
            title = {
                Text(text = "Confirma deletar a despesa")
            },
            text = {
                Column() {
                    Text("Você quer deletar a despesa")
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
