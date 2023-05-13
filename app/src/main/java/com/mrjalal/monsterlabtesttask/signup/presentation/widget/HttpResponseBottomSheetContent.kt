package com.mrjalal.monsterlabtesttask.signup.presentation.widget

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mrjalal.monsterlabtesttask.R
import com.mrjalal.monsterlabtesttask.core.presentation.widget.CustomIcon
import com.mrjalal.monsterlabtesttask.signup.presentation.model.HttpResponseItem

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HttpResponseBottomSheetContent(
    data: List<HttpResponseItem>,
    onItemClick: (HttpResponseItem) -> Unit,
) {
    val title = stringResource(id = R.string.choose_signup_result)

    LazyColumn {
        stickyHeader {
            TopAppBar(
                title = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
            )
        }

        item {
            Spacer(modifier = Modifier.requiredSize(20.dp))
        }

        items(data.size, key = { data[it].code }) {
            BottomSheetItem(
                item = data[it],
                onPress = onItemClick
            )
        }

        item {
            Spacer(modifier = Modifier.requiredSize(60.dp))
        }
    }
}