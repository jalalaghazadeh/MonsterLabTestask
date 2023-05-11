package com.mrjalal.monsterlabtesttask.signup.presentation.model

data class SignUpUiState(
    val email: String = "",
    val password: String = "",
    val isButtonEnable: Boolean = false
)
