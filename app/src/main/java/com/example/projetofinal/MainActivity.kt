package com.example.projetofinal


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.projetofinal.ui.theme.ProjetoFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DefaultPreview()
                }
            }
        }
    }
}

@Composable
fun Conteudo() {

    val usuario = remember {
        //lembrar da variavel
        mutableStateOf(value = "")
    }
    val senha = remember {
        //lembrar da variavel
        mutableStateOf(value = "")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = stringResource(id = com.example.projetofinal.R.string.titulo),
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            color = androidx.compose.ui.graphics.Color.Red,
        )

        Text(
            text = stringResource(id = com.example.projetofinal.R.string.login),
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Left,
            modifier = Modifier


        )
        OutlinedTextField(
            value = usuario.value,
            onValueChange = {
                usuario.value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Text(
            text = stringResource(id = com.example.projetofinal.R.string.senha),
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Start
        )
        OutlinedTextField(
            value = senha.value,
            onValueChange = {
                senha.value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFF0000))) {
            Text(text = stringResource(com.example.projetofinal.R.string.botao), color = androidx.compose.ui.graphics.Color.White)

        }

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFF0000))) {
            Text(
                text = stringResource(com.example.projetofinal.R.string.novoRegistro),
                color = androidx.compose.ui.graphics.Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProjetoFinalTheme {
        Conteudo()
    }
}