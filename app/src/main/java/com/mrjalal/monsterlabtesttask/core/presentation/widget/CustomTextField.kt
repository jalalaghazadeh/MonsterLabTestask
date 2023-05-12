package com.mrjalal.monsterlabtesttask.core.presentation.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    hint: String,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
) {

    val textFieldColors = TextFieldDefaults.textFieldColors(
        textColor = MaterialTheme.colorScheme.secondary,
        containerColor = Color.White,
        cursorColor = MaterialTheme.colorScheme.tertiary,
        errorCursorColor = Color.Red,
        focusedIndicatorColor = Color.White,
        unfocusedIndicatorColor = Color.White,
        errorIndicatorColor = Color.White,
        focusedLabelColor = MaterialTheme.colorScheme.tertiary,
        errorLabelColor = Color.Red,
        errorSupportingTextColor = Color.Red
    )

    val roundedRectangleShape = RoundedCornerShape(8.dp)


    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        label = {
            Text(
                text = hint,
                style = MaterialTheme.typography.labelMedium
            )
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        colors = textFieldColors,
        shape = roundedRectangleShape,
        singleLine = true,
        maxLines = 1,
        isError = true
    )

}