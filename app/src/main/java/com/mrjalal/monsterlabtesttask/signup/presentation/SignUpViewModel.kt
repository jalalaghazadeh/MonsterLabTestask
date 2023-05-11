package com.mrjalal.monsterlabtesttask.signup.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrjalal.monsterlabtesttask.signup.domain.usecase.SignUpUseCase
import com.mrjalal.monsterlabtesttask.signup.presentation.model.SignUpUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {

    // inorder to protect UiState from being modified from outside of ViewModel
    private var _uiState: MutableStateFlow<SignUpUiState> = MutableStateFlow(SignUpUiState())
    val uiState = _uiState

    internal fun onEmailValueChange(email: String) {
        updateUiState(email = email)
    }

    internal fun onPasswordValueChange(password: String) {
        updateUiState(password = password)
    }

    internal fun onButtonPressed(onNavigate: (String) -> Unit) {

        val email = _uiState.value.email
        val password = _uiState.value.password

        viewModelScope.launch {
            when (signUpUseCase.execute(email, password)) {
                // is success
                // is failure
            }
        }
    }

    private fun updateUiState(
        email: String = _uiState.value.email,
        password: String = _uiState.value.password
    ) {
        val isEmailValid = signUpUseCase.validateEmail(email)
        val isPasswordValid = signUpUseCase.validatePassword(password)

        val newUiState = _uiState.value.copy(
            email = email,
            password = password,
            isButtonEnable = isEmailValid && isPasswordValid
        )
        viewModelScope.launch { _uiState.emit(newUiState) }
    }
}