package com.mrjalal.monsterlabtesttask.core.presentation.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrjalal.monsterlabtesttask.R

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
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        errorIndicatorColor = Color.Transparent,
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
    )
}

@Preview(
    name = "default",
    widthDp = 300,
    heightDp = 100,
    backgroundColor = 0xfff0f0f0,
    showBackground = true
)
@Composable
fun Preview_CustomTextField_Default() {

    var password = remember { "" }
    val onValueChange: (String) -> Unit = { password = it }

    CustomTextField(
        value = password,
        onValueChange = { onValueChange(it) },
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(52.dp)
            .padding(horizontal = 20.dp),
        hint = "password",
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(
            onDone = { }
        ),
    )

}