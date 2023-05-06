package com.example.projetofinal.ui.theme

import android.app.Application
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projetofinal.R
import com.example.projetofinal.viewModel.RegistroNovoUsuarioViewModel
import com.example.projetofinal.viewModel.RegistroNovoUsuarioViewModelFactory


@Composable
fun TelaCadastro(onNavigate : (route: String) ->Unit, onBackScreen:() -> Unit) {

    val application = LocalContext.current.applicationContext as Application

    val viewModel : RegistroNovoUsuarioViewModel = viewModel(
        factory = RegistroNovoUsuarioViewModelFactory(application)
    )

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
                value = viewModel.novoNome,
                onValueChange = {
                    viewModel.novoNome = it
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
                value = viewModel.Novousuario,
                onValueChange = {
                    viewModel.Novousuario = it
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
                value = viewModel.Novasenha,
                onValueChange = {
                    viewModel.Novasenha = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.alignByBaseline()
            )
        }

        Spacer(modifier = Modifier.size(30.dp))

        Row() {
            Button(onClick = {viewModel.registrar()},
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






