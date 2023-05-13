package com.mrjalal.monsterlabtesttask.signup.presentation.model

data class SignUpUiState(
    val email: String = "",
    val password: String = "",
    val isButtonEnable: Boolean = false,
    val httpCode: Int = 200,
    val sheetList: List<HttpResponseItem> = initSheetData(),
    val alertMessage: String? = null
)

fun initSheetData(): List<HttpResponseItem> {
    return listOf(
        HttpResponseItem(label = "Success (200)", code = 200, isSelected = true),
        HttpResponseItem(label = "Forbidden (403)", code = 403, isSelected = false),
        HttpResponseItem(label = "Unauthorized (401)", code = 401, isSelected = false),
    )
}
