package com.example.registro_clientes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.registro_clientes.navigation.NavManager
import com.example.registro_clientes.room.UsuariosDatabase
import com.example.registro_clientes.ui.theme.Registro_ClientesTheme
import com.example.registro_clientes.viewmodels.UsuariosViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Registro_ClientesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database = Room.databaseBuilder(this, UsuariosDatabase::class.java, "db_usuarios").build()
                    val dao = database.usuariosDao()

                    val viewModel = UsuariosViewModel(dao)

                    NavManager(viewModel = viewModel)
                }
            }
        }
    }
}

