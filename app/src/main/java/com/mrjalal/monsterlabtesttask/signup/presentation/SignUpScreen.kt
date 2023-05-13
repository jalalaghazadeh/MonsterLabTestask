package com.mrjalal.monsterlabtesttask.signup.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mrjalal.monsterlabtesttask.R
import com.mrjalal.monsterlabtesttask.core.presentation.widget.BackButtonHandler
import com.mrjalal.monsterlabtesttask.core.presentation.widget.CustomIcon
import com.mrjalal.monsterlabtesttask.signup.presentation.widget.HttpResponseBottomSheetContent
import com.mrjalal.monsterlabtesttask.signup.presentation.widget.SignUpScreenContent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit,
    onCloseApp: () -> Unit,
) {

    val uiState = viewModel.uiState.collectAsState()

    val focusManager = LocalFocusManager.current

    // scaffold
    val scaffoldState = rememberScaffoldState()
    val snackbarHostState = scaffoldState.snackbarHostState

    // bottom-sheet
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    val onOpenSheet: () -> Unit = { coroutineScope.launch { sheetState.show() } }

    val onDismiss: () -> Unit = { coroutineScope.launch { sheetState.hide() } }

    BackButtonHandler {
        if(sheetState.isVisible) {
            onDismiss()
            return@BackButtonHandler
        }

        onCloseApp()
    }

    LaunchedEffect(key1 = uiState.value.alertMessage) {
        uiState.value.alertMessage?.let {
            scaffoldState.snackbarHostState.showSnackbar(message = it)
        }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            HttpResponseBottomSheetContent(
                data = uiState.value.sheetList,
                onItemClick = {
                    viewModel.onHttpResponseSheetItemPressed(it)
                    coroutineScope.launch {
                        delay(300)
                        onDismiss()
                    }
                },
            )
        },
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {},
                    navigationIcon = {
                        CustomIcon(
                            iconId = R.drawable.ic_cross,
                            onClick = onCloseApp,
                            tintColor = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier.padding(16.dp)
                        )
                    },
                    actions = {
                        CustomIcon(
                            iconId = R.drawable.ic_setting,
                            onClick = onOpenSheet,
                            tintColor = MaterialTheme.colorScheme.tertiary,
                        )
                    },
                )
            },
            scaffoldState = scaffoldState,
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            backgroundColor = MaterialTheme.colorScheme.background,
        ) {
            SignUpScreenContent(
                state = uiState.value,
                onEmailValueChange = { email -> viewModel.onEmailValueChange(email) },
                onPasswordValueChange = { password -> viewModel.onPasswordValueChange(password) },
                onButtonPressed = {
                    focusManager.clearFocus()
                    viewModel.onButtonPressed(onNavigate)
                },
                paddingValues = it,
            )
        }
    }
}