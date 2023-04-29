package com.example.projetofinal



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projetofinal.ui.theme.*

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


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProjetoFinalTheme {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "TelaLogin") {

            composable("TelaLogin") {
                TelaLogin(onNavigate = {navController.navigate(it)})
            }

            composable("TelaCadastro"){
                TelaCadastro(onNavigate = {navController.navigate(it)}, onBackScreen = {navController.navigateUp()})
            }

            composable("TelaMenu"){
                TelaMenu(onNavigate = {navController.navigate(it)})
            }
            
            composable("TelaNovaViagem"){
                TelaNovaViagem(onNavigate = {navController.navigate(it)})
            }
            
            composable("TelaInicial"){
                telaInicial(onNavigate = {navController.navigate(it)})
            }

            composable("TelaSobre"){
                telaSobre(onNavigate = {navController.navigate(it)})
            }
            
            composable("TelaViagensDisp"){
                    telaViagemDisp(onNavigate = {navController.navigate(it)})
            }

        }
    }
}