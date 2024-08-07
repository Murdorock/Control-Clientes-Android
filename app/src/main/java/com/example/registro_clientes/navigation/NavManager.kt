package com.example.registro_clientes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.registro_clientes.viewmodels.UsuariosViewModel
import com.example.registro_clientes.views.AgregarView
import com.example.registro_clientes.views.EditarView
import com.example.registro_clientes.views.InicioView

@Composable
fun NavManager(viewModel: UsuariosViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            InicioView(navController, viewModel)
        }

        composable("agregar") {
            AgregarView(navController, viewModel)
        }

        composable("editar/{id}/{cedula}/{nombre}/{apellido}/{correo}/{telefono}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("cedula") { type = NavType.StringType },
            navArgument("nombre") { type = NavType.StringType },
            navArgument("apellido") { type = NavType.StringType },
            navArgument("correo") { type = NavType.StringType },
            navArgument("telefono") { type = NavType.StringType }
        )) {
            EditarView(
                navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("cedula"),
                it.arguments?.getString("nombre"),
                it.arguments?.getString("apellido"),
                it.arguments?.getString("correo"),
                it.arguments?.getString("telefono")
            )
        }
    }

}