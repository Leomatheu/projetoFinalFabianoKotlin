package com.example.projetofinal.ui.theme

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projetofinal.viewModel.RegistroNovaDespesaViewModel
import com.example.projetofinal.viewModel.RegistroNovaDespesaViewModelFactory
import kotlinx.coroutines.flow.collectLatest

@Composable
fun telaDespesa(onNavigate : (route: String) ->Unit, onBackScreen:() -> Unit) {

    val application = LocalContext.current.applicationContext as Application

    val viewModel : RegistroNovaDespesaViewModel = viewModel(
        factory = RegistroNovaDespesaViewModelFactory(application)
    )
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(Unit) {
        viewModel.toastMessage.collectLatest {
            scaffoldState.snackbarHostState.showSnackbar(
                message = it,
                duration = SnackbarDuration.Long
            )
            // opção para mostrar as mensagens
            // Toast.makeText(ctx, it, Toast.LENGTH_SHORT).show()
        }
    }


    val focusManager = LocalFocusManager.current
    Scaffold(scaffoldState = scaffoldState ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = stringResource(id = com.example.projetofinal.R.string.dataDespesa),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.alignByBaseline()

                )

                Spacer(modifier = Modifier.size(16.dp))

                OutlinedTextField(
                    value = viewModel.data,
                    onValueChange = {
                        viewModel.data = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.alignByBaseline()
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Row(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = stringResource(id = com.example.projetofinal.R.string.valorDespesa),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.alignByBaseline()

                )

                Spacer(modifier = Modifier.size(5.dp))

                OutlinedTextField(
                    value = viewModel.valor,
                    onValueChange = {
                        viewModel.valor = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.alignByBaseline()
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Row(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = stringResource(id = com.example.projetofinal.R.string.tipoDespesa),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.alignByBaseline()

                )

                Spacer(modifier = Modifier.size(10.dp))
                OutlinedTextField(
                    value = viewModel.tipo,
                    onValueChange = {
                        viewModel.tipo = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.alignByBaseline()
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Row(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = stringResource(id = com.example.projetofinal.R.string.descricao),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.alignByBaseline()

                )

                Spacer(modifier = Modifier.size(10.dp))
                OutlinedTextField(
                    value = viewModel.descricao,
                    onValueChange = {
                        viewModel.descricao = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.alignByBaseline()
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Row(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = stringResource(id = com.example.projetofinal.R.string.codigoViagem),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.alignByBaseline()

                )

                Spacer(modifier = Modifier.size(10.dp))
                OutlinedTextField(
                    value = viewModel.codigoViagem,
                    onValueChange = {
                        viewModel.codigoViagem = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.alignByBaseline()
                )
            }


            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Button(
                    onClick = {
                        viewModel.registrarDespesa()
                        focusManager.clearFocus()
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF778E6C))
                ) {
                    Text(
                        text = stringResource(com.example.projetofinal.R.string.novoRegistro),
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.size(10.dp))

                Button(
                    onClick = { onBackScreen() },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF778E6C))
                ) {
                    Text(
                        text = stringResource(com.example.projetofinal.R.string.voltar),
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.size(10.dp))

                Button(
                    onClick = { onNavigate("TelaDespesaDisp") },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF778E6C))
                ) {
                    Text(
                        text = stringResource(com.example.projetofinal.R.string.listaDespesas),
                        color = Color.Black
                    )
                }
            }
        }
    }
}