package com.example.pamprak6.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pamprak6.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    nama: String,
    jk: String,
    status: String,
    alamat: String,
    onBackBtnClick: () -> Unit,
    onHomeBtnClick: () -> Unit
) {
    val items = listOf(
        Pair(first = stringResource(id = R.string.nama_Lengkap), second = nama),
        Pair(first = stringResource(id = R.string.jenis_kelamin), second = jk),
        Pair(first = "STATUS PERKAWINAN", second = status),
        Pair(first = stringResource(id = R.string.alamat), second = alamat)
    )
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "List Daftar Peserta",
                        fontSize = 30.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_400)
                )
            )
        }
    ) {
            isiRuang ->
        Column(
            modifier = Modifier.padding(isiRuang),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(all = dimensionResource(id = R.dimen.padding_medium)),
                verticalArrangement = Arrangement.spacedBy(space = dimensionResource(id = R.dimen.padding_small))
            ) {
                items.forEach { item ->
                    ElevatedCard(
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = item.first.uppercase(),
                                fontSize = 16.sp
                            )
                            Text(
                                text = item.second,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Cursive,
                                fontSize = 22.sp
                            )
                        }
                        HorizontalDivider(thickness = 1.dp)
                    }
                }
            }
        }
    }
}