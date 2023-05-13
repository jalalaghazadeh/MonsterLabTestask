package com.mrjalal.monsterlabtesttask.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mrjalal.monsterlabtesttask.R
import com.mrjalal.monsterlabtesttask.core.presentation.widget.CustomIcon

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onBack: () -> Unit
) {

    val home = stringResource(id = R.string.home)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = home, style = MaterialTheme.typography.bodyMedium)
                },
                navigationIcon = {
                    CustomIcon(
                        iconId = R.drawable.ic_cross,
                        onClick = onBack,
                        tintColor = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            )
        },
        backgroundColor = MaterialTheme.colorScheme.background,
    ) {
    }
}