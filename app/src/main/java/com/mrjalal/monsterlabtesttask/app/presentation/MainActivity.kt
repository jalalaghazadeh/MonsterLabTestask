package com.mrjalal.monsterlabtesttask.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mrjalal.monsterlabtesttask.app.MonsterLabApp
import com.mrjalal.monsterlabtesttask.app.presentation.ui.theme.MonsterlabTestTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonsterlabTestTaskTheme {
                MonsterLabApp(onCloseApp = { onCloseApp() })
            }
        }
    }

    private fun onCloseApp() {
        finish()
    }
}