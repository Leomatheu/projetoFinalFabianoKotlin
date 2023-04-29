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
fun TelaCadastro(onNavigate : (route: String) ->Unit, onBackScreen:() -> Unit) {

    val Novousuario = remember {
        //lembrar da variavel
        mutableStateOf(value = "")
    }
    val novoNome = remember {
        mutableStateOf(value = "")
    }
    val Novasenha = remember {
        //lembrar da variavel
        mutableStateOf(value = "")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF8F7F4)),
        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
        Row( modifier = Modifier
            .padding(20.dp)) {
            Text(
                text = stringResource(id = R.string.nome),
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Start,
                modifier = Modifier.alignByBaseline()

            )

            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(
                value = novoNome.value,
                onValueChange = {
                    novoNome.value = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.alignByBaseline()
            )
        }

        Spacer(modifier = Modifier.size(10.dp))

        Row(modifier = Modifier.padding(20.dp)) {
            Text(
                text = stringResource(id = R.string.usuario),
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Start,
                modifier = Modifier.alignByBaseline()

            )

            Spacer(modifier = Modifier.size(5.dp))
            OutlinedTextField(
                value = Novousuario.value,
                onValueChange = {
                    Novousuario.value = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.alignByBaseline()
            )
        }

        Spacer(modifier = Modifier.size(10.dp))

        Row(modifier = Modifier.padding(20.dp)) {
            Text(
                text = stringResource(id = R.string.senhaCad),
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Start,
                modifier = Modifier.alignByBaseline()

            )

            Spacer(modifier = Modifier.size(10.dp))
            OutlinedTextField(
                value = Novasenha.value,
                onValueChange = {
                    Novasenha.value = it
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

            Button(onClick = {onBackScreen()},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF778E6C))) {
                Text(
                    text = stringResource(R.string.voltar),
                    color = Color.Black
                )
            }

        }
    }
}






