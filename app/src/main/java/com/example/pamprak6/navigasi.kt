package com.example.pamprak6

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pamprak6.view.FormDataDiri
import com.example.pamprak6.view.TampilData
import com.example.pamprak6.view.TampilanAwal

enum class Navigasi {
    Awal,
    Formulirku,
    Detail
}
@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Awal.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            composable(route = Navigasi.Awal.name) {
                TampilanAwal(
                    onSubmitClick = {
                        navController.navigate(Navigasi.Formulirku.name)
                    }
                )
            }
        }
    }
}