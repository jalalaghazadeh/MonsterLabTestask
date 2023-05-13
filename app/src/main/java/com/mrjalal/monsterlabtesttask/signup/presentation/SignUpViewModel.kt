package com.mrjalal.monsterlabtesttask.signup.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrjalal.monsterlabtesttask.core.domain.HttpCodeException
import com.mrjalal.monsterlabtesttask.core.presentation.Screen
import com.mrjalal.monsterlabtesttask.signup.domain.usecase.SignUpUseCase
import com.mrjalal.monsterlabtesttask.signup.presentation.model.HttpResponseItem
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

        updateButtonLoading(true)

        val email = _uiState.value.email
        val password = _uiState.value.password
        val responseCode = _uiState.value.httpCode

        viewModelScope.launch {
            val response = signUpUseCase.execute(email, password, responseCode)
            if (response.isSuccess) {
                onNavigate(Screen.Home.route)
            } else {
                val message = when ((response.exceptionOrNull() as HttpCodeException).errorCode) {
                    403 -> "You don't have permission to register"
                    else -> "Something went wrong :("
                }
                updateUiState(alertMessage = message)
            }
            updateButtonLoading(false)
        }
    }

    internal fun onHttpResponseSheetItemPressed(item: HttpResponseItem) {
        updateUiState(
            httpCode = item.code,
            sheetList = getUpdatedSheetList(item)
        )
    }

    // +++++++++++++++++++++++
    // mutating ui-state
    // +++++++++++++++++++++++

    private fun updateUiState(
        email: String = _uiState.value.email,
        password: String = _uiState.value.password,
        httpCode: Int = _uiState.value.httpCode,
        sheetList: List<HttpResponseItem> = _uiState.value.sheetList,
        alertMessage: String? = _uiState.value.alertMessage,
        isButtonLoading: Boolean = _uiState.value.isButtonLoading,
    ) {
        val isEmailValid = signUpUseCase.validateEmail(email)
        val isPasswordValid = signUpUseCase.validatePassword(password)

        val newUiState = _uiState.value.copy(
            email = email,
            password = password,
            isButtonEnable = isEmailValid && isPasswordValid,
            httpCode = httpCode,
            sheetList = sheetList,
            alertMessage = alertMessage,
            isButtonLoading = isButtonLoading,
        )
        viewModelScope.launch { _uiState.emit(newUiState) }
    }

    private fun getUpdatedSheetList(item: HttpResponseItem): List<HttpResponseItem> {
        return _uiState.value.sheetList.map {
            it.copy(isSelected = it.code == item.code)
        }
    }

    private fun updateButtonLoading(loading: Boolean) {
        updateUiState(isButtonLoading = loading)
    }
}