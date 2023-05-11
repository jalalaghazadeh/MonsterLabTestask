package com.mrjalal.monsterlabtesttask.core.presentation.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    iconId: Int? = null,
    buttonText: String? = null,
    onClick: () -> Unit,
    iconDescription: String = "icon",
    tintColor: Color = Color.Black,
) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            iconId?.let {
                Icon(
                    painter = painterResource(it),
                    contentDescription = iconDescription,
                    tint = tintColor,
                    modifier = Modifier.size(24.dp)
                )
            }
            if(iconId != null && buttonText != null) {
                Spacer(modifier = Modifier.width(8.dp))
            }
            buttonText?.let {
                Text(text = it)
            }
        }
    }
}