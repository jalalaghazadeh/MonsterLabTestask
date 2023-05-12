package com.mrjalal.monsterlabtesttask.core.presentation.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    iconId: Int? = null,
    buttonText: String? = null,
    buttonTextStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    onClick: () -> Unit,
    iconDescription: String = "icon",
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    tintColor: Color = Color.Black,
    isEnable: Boolean = true,
) {

    val defaultHeight = 52.dp

    val roundedRectangleShape = RoundedCornerShape(8.dp)

    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = backgroundColor,
    )

    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(defaultHeight)
            .then(modifier),
        shape = roundedRectangleShape,
        colors = buttonColors,
        enabled = isEnable
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
                Text(text = it, style = buttonTextStyle)
            }
        }
    }
}