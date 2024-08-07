package com.example.registro_clientes.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registro_clientes.models.Usuarios
import com.example.registro_clientes.room.UsuariosDatabaseDao
import com.example.registro_clientes.states.UsuariosState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UsuariosViewModel(
    private val dao: UsuariosDatabaseDao
): ViewModel() {

    var state by mutableStateOf(UsuariosState())
        private set

    init {
        viewModelScope.launch {
            dao.obtenerUsuarios().collectLatest {
                state = state.copy(
                    listaUsuarios = it
                )
            }
        }
    }

    fun agregarUsuario(usuario: Usuarios) = viewModelScope.launch {
        dao.agregarUsuario(usuario = usuario)
    }

    fun actualizarUsuario(usuario: Usuarios) = viewModelScope.launch {
        dao.actualizarUsuario(usuario = usuario)
    }

    fun borrarUsuario(usuario: Usuarios) = viewModelScope.launch {
        dao.borrarUsuario(usuario = usuario)
    }

}