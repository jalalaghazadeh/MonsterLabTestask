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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrjalal.monsterlabtesttask.R

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
    isLoading: Boolean = false,
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
        enabled = isEnable && !isLoading
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = tintColor
                )
            } else {
                iconId?.let {
                    Icon(
                        painter = painterResource(it),
                        contentDescription = iconDescription,
                        tint = tintColor,
                        modifier = Modifier.size(24.dp)
                    )
                }
                if (iconId != null && buttonText != null) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
                buttonText?.let {
                    Text(text = it, style = buttonTextStyle)
                }
            }
        }
    }
}

@Preview(
    name = "default",
    widthDp = 200,
    heightDp = 200,
    backgroundColor = 0xffffffff,
    showBackground = true
)
@Composable
fun Preview_CustomButton_Default() {
    CustomButton(
        buttonText = "Button",
        iconId = R.drawable.ic_apple,
        backgroundColor = Color.Blue,
        tintColor = Color.Black,
        buttonTextStyle = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
        onClick = { /*TODO*/ },
    )
}