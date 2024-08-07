package com.example.registro_clientes.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.registro_clientes.models.Usuarios
import com.example.registro_clientes.viewmodels.UsuariosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarView(navController: NavController, viewModel: UsuariosViewModel, id: Int, cedula: String?, nombre: String?, apellido: String?, correo: String?, telefono: String?) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Editar Cliente", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Regresar", tint = Color.White)
                    }
                }
            )
        }
    ) {
        ContentEditarView(it, navController, viewModel, id, cedula, nombre, apellido, correo, telefono)
    }
}

@Composable
fun ContentEditarView(it: PaddingValues, navController: NavController, viewModel: UsuariosViewModel, id: Int, cedula: String?, nombre: String?, apellido: String?, correo: String?, telefono: String?) {
    var cedula by remember { mutableStateOf(cedula) }
    var nombre by remember { mutableStateOf(nombre) }
    var apellido by remember { mutableStateOf(apellido) }
    var correo by remember { mutableStateOf(correo) }
    var telefono by remember { mutableStateOf(telefono) }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = cedula ?: "",
            onValueChange = { cedula = it },
            label = { Text(text = "Cédula") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = nombre ?: "",
            onValueChange = { nombre = it },
            label = { Text(text = "Nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = apellido ?: "",
            onValueChange = { apellido = it },
            label = { Text(text = "Apellido") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = correo ?: "",
            onValueChange = { correo = it },
            label = { Text(text = "Correo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = telefono ?: "",
            onValueChange = { telefono = it },
            label = { Text(text = "Teléfono") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        Button(
            onClick = {
                val usuario = Usuarios(id = id, cedula = cedula!!, nombre = nombre!!, apellido = apellido!!, correo = correo!!, telefono = telefono!!)
                viewModel.actualizarUsuario(usuario)
                navController.popBackStack()
            }
        ) {
            Text(text = "Editar")
        }
    }
}