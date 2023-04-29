package com.example.projetofinal.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun TelaMenu(onNavigate : (route: String) ->Unit){

    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(
                Modifier.background(color = Color(0xFFF8F7F4))
            ) {
                BottomNavigationItem(
                    selected = true,
                    onClick = { navController.navigate("TelaNovaViagem")
                    },
                    label = {
                        Text(text = "Nova Viagem")
                    },
                    icon = {
                        Icon(Icons.Filled.Home, contentDescription = "")
                    }
                )
                BottomNavigationItem(
                    selected = true,
                    onClick = { navController.navigate("TelaViagensDisp")
                    },
                    label = {
                        Text(text = "Viagens")
                    },
                    icon = {
                        Icon(Icons.Filled.Add, contentDescription = "")
                    }
                )
                BottomNavigationItem(
                    selected = true,
                    onClick = { navController.navigate("TelaSobre")
                    },
                    label = {
                        Text(text = "Sobre")
                    },
                    icon = {
                        Icon(Icons.Filled.AccountBox, contentDescription = "")
                    }
                )
            }
        }) {
        NavHost(
            navController = navController,
            startDestination = "TelaInicial",
            modifier = Modifier
                .padding(paddingValues = it)

        )
        {
            composable("TelaInicial"){
                telaInicial(onNavigate = {navController.navigate(it)})
            }

            composable("TelaNovaViagem") {
                 TelaNovaViagem(onNavigate = {navController.navigate(it)})
            }

            composable("TelaViagensDisp") {
                 telaViagemDisp(onNavigate = {navController.navigate(it)})   
            }

            composable("TelaSobre") {
                telaSobre(onNavigate = {navController.navigate(it)})
            }
        }
    }
}