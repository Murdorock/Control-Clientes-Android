package com.example.registro_clientes.states

import com.example.registro_clientes.models.Usuarios

data class UsuariosState(
    val listaUsuarios: List<Usuarios> = emptyList()
)
