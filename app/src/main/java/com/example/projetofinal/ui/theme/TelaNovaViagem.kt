package com.example.projetofinal.ui.theme

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.projetofinal.viewModel.RegistroNovaViagemViewModel
import com.example.projetofinal.viewModel.RegistroNovaViagemViewModelfactory
import com.example.projetofinal.viewModel.RegistroNovoUsuarioViewModel
import com.example.projetofinal.viewModel.RegistroNovoUsuarioViewModelFactory
import kotlinx.coroutines.flow.collectLatest

@Composable
fun TelaNovaViagem(onNavigate : (route: String) ->Unit){

    val application = LocalContext.current.applicationContext as Application

    val viewModel : RegistroNovaViagemViewModel = viewModel(
        factory = RegistroNovaViagemViewModelfactory (application)
    )
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(Unit) {
        viewModel.toastMessage.collectLatest {
            scaffoldState.snackbarHostState.showSnackbar(
                message = it,
                duration = SnackbarDuration.Long
            )
        }
    }

    Scaffold(scaffoldState = scaffoldState ) {
        Column(modifier = Modifier.padding(paddingValues = it)) {
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
                        value = viewModel.destino,
                        onValueChange = {
                            viewModel.destino = it
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
                        value = viewModel.dataInicio,
                        onValueChange = {
                            viewModel.dataInicio = it
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
                        value = viewModel.dataFim,
                        onValueChange = {
                            viewModel.dataFim = it
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
                        value = viewModel.orcamento,
                        onValueChange = {
                            viewModel.orcamento = it
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
}