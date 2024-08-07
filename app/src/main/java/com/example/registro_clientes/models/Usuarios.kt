package com.example.registro_clientes.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuarios(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("cedula")
    val cedula: String,
    @ColumnInfo("nombre")
    val nombre: String,
    @ColumnInfo("apellido")
    val apellido: String,
    @ColumnInfo("correo")
    val correo: String,
    @ColumnInfo("telefono")
    val telefono: String
)
