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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projetofinal.R
import com.example.projetofinal.viewModel.LoginViewModel
import com.example.projetofinal.viewModel.LoginViewModelFactory
import kotlinx.coroutines.flow.collectLatest

@Composable
fun TelaLogin(onNavigate : (route: String) ->Unit) {

    val application = LocalContext.current.applicationContext as Application
    val viewModel: LoginViewModel = viewModel(factory = LoginViewModelFactory(application))
    val ctx = LocalContext.current

    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(Unit) {
        viewModel.toastMessage.collectLatest {
            scaffoldState.snackbarHostState.showSnackbar(
                message = it,
                duration = SnackbarDuration.Long
            )
        }
    }

    val focusManager = LocalFocusManager.current

    Scaffold(scaffoldState = scaffoldState ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFF8F7F4))
                .padding(paddingValues = it),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = stringResource(id = R.string.titulo),
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Center,
                color = Color(0xFF23A196),
                modifier = Modifier
                    .padding(50.dp)
            )

            Row() {
                Text(
                    text = stringResource(id = R.string.login),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.alignByBaseline()

                )

                Spacer(modifier = Modifier.size(16.dp))
                OutlinedTextField(
                    value = viewModel.nome,
                    onValueChange = {
                        viewModel.nome = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.alignByBaseline()
                )
            }

            Spacer(modifier = Modifier.size(16.dp))

            Row() {
                Text(
                    text = stringResource(id = R.string.senha),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.alignByBaseline()
                )
                Spacer(modifier = Modifier.size(13.dp))
                OutlinedTextField(
                    value = viewModel.senha,
                    onValueChange = {
                        viewModel.senha = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.alignByBaseline()
                )
            }

            Spacer(modifier = Modifier.size(20.dp))

            Button(onClick = {viewModel.validateLogin { if (it){ onNavigate("TelaMenu")  }
            }},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF778E6C))) {
                Text(text = stringResource(R.string.botao), color = Color.Black)

            }

            Spacer(modifier = Modifier.size(30.dp))

            Button(onClick = {onNavigate("TelaCadastro")},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF778E6C))) {
                Text(
                    text = stringResource(R.string.novoRegistro),
                    color = Color.Black
                )
            }
        }
    }
}
