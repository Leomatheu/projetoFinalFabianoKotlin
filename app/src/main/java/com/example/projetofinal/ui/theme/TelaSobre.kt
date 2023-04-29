package com.example.projetofinal.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.projetofinal.R

@Composable
fun telaSobre(onNavigate : (route: String) ->Unit){
    Column() {
        Spacer(modifier = Modifier.size(200.dp))
        Row() {
            Spacer(modifier = Modifier.size(50.dp))
            Text(
                text = stringResource(com.example.projetofinal.R.string.feito),
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Start,
            )
        }

        Row() {
            Spacer(modifier = Modifier.size(50.dp))
            Text(
                text = stringResource(com.example.projetofinal.R.string.eu),
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Start,
            )
        }
    }
}
