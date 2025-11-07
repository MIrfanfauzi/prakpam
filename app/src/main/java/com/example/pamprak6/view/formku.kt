package com.example.pamprak6.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pamprak6.R

@Composable
fun FormDataDiri(
    modifier: Modifier = Modifier,
    onSubmitClick: (String, String, String, String) -> Unit
) {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    val gender = listOf("Laki-Laki", "Perempuan")
    val statusKawin = listOf("Janda", "Lajang", "Duda")

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.purple_300),
                        colorResource(id = R.color.purple_400))
                )
            )
            .padding(bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.purple_400))
                .padding(vertical = 40.dp)
        ) {
            Text(
                text = "Formulir Pendaftaran",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(text = "NAMA LENGKAP", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Isian nama lengkap") },
                    onValueChange = { textNama = it }
                )
                Text(text = "JENIS KELAMIN", fontWeight = FontWeight.SemiBold)
                gender.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                            selected = textJK == item,
                            onClick = { textJK = item }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(selected = textJK == item, onClick = { textJK = item })
                        Text(text = item)
                    }
                }
                Text(text = "STATUS PERKAWINAN", fontWeight = FontWeight.SemiBold)
                statusKawin.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                            selected = textStatus == item,
                            onClick = { textStatus = item }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(selected = textStatus == item, onClick = { textStatus = item })
                        Text(text = item)
                    }
                }
                Text(text = "ALAMAT", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = textAlamat,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Alamat") },
                    onValueChange = { textAlamat = it }
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.purple_500)),
                    enabled = textNama.isNotEmpty() && textAlamat.isNotEmpty(),
                    onClick = {
                        onSubmitClick(textNama, textJK, textStatus, textAlamat)
                    }
                ) {
                    Text(text = stringResource(id = R.string.submit), color = Color.White)
                }
            }
        }
    }
}