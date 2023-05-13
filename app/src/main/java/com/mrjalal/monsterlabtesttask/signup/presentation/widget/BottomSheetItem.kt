package com.mrjalal.monsterlabtesttask.signup.presentation.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mrjalal.monsterlabtesttask.signup.presentation.model.HttpResponseItem

@Composable
fun BottomSheetItem(
    item: HttpResponseItem,
    onPress: (HttpResponseItem) -> Unit
) {
    val colors = RadioButtonDefaults.colors(
        selectedColor = Color.Red,
        unselectedColor = Color.Gray
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = item.isSelected,
                onClick = { onPress(item) }
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = item.isSelected,
            onClick = { onPress(item) },
            colors = colors
        )
        Text(text = item.label, Modifier.padding(start = 16.dp))
    }
}