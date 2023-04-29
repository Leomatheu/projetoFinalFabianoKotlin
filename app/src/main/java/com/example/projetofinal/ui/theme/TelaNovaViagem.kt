package com.example.projetofinal.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.projetofinal.R

@Composable
fun TelaNovaViagem(onNavigate : (route: String) ->Unit){
    val destino = remember {
        //lembrar da variavel
        mutableStateOf(value = "")
    }
    val dataInicio = remember {
        mutableStateOf(value = "")
    }
    val dataFim = remember {
        //lembrar da variavel
        mutableStateOf(value = "")
    }
    val orcamento = remember {
        //lembrar da variavel
        mutableStateOf(value = "")
    }

    Column() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFF8F7F4)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row( modifier = Modifier.padding(20.dp)) {
                Text(
                    text = stringResource(id = R.string.destino),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.alignByBaseline()

                )

                Spacer(modifier = Modifier.size(40.dp))
                OutlinedTextField(
                    value = destino.value,
                    onValueChange = {
                        destino.value = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.alignByBaseline()
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Row(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = stringResource(id = R.string.dataInicial),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.alignByBaseline()

                )

                Spacer(modifier = Modifier.size(15.dp))
                OutlinedTextField(
                    value = dataInicio.value,
                    onValueChange = {
                        dataInicio.value = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.alignByBaseline()
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Row(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = stringResource(id = R.string.dataFinal),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.alignByBaseline()

                )

                Spacer(modifier = Modifier.size(34.dp))
                OutlinedTextField(
                    value = dataFim.value,
                    onValueChange = {
                        dataFim.value = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.alignByBaseline()
                )
            }

            Spacer(modifier = Modifier.size(30.dp))

            Row(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = stringResource(id = R.string.orcamento),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.alignByBaseline()

                )

                Spacer(modifier = Modifier.size(10.dp))
                OutlinedTextField(
                    value = orcamento.value,
                    onValueChange = {
                        orcamento.value = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.alignByBaseline()
                )
            }

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF778E6C))) {
                    Text(
                        text = stringResource(R.string.novoRegistro),
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.size(15.dp))
            }
        }

    }

}