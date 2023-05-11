package com.mrjalal.monsterlabtesttask.signup.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mrjalal.monsterlabtesttask.R
import com.mrjalal.monsterlabtesttask.core.presentation.widget.CustomButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit,
    onCloseApp: () -> Unit,
) {
    val laterText = stringResource(id = R.string.later)
    val createAnAccountText = stringResource(id = R.string.create_an_account)
    val alreadyHaveAnAccount = stringResource(id = R.string.already_have_an_account)
    val continueWithGoogle = stringResource(id = R.string.continue_with_google)
    val continueWithFacebook = stringResource(id = R.string.continue_with_facebook)
    val continueWithApple = stringResource(id = R.string.continue_with_apple)

    val uiState = viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    CustomButton(
                        iconId = R.drawable.ic_cross,
                        onClick = onCloseApp
                    )
                },
                actions = { Text(text = laterText) }
            )
        }
    ) {
        LazyColumn {
            item {
                Text(text = createAnAccountText)
            }

            item {
                Column {
                    // email text input
                    TextField(
                        value = uiState.value.email,
                        onValueChange = { viewModel.onEmailValueChange(it) })
                    // password text input
                    TextField(
                        value = uiState.value.password,
                        onValueChange = { viewModel.onPasswordValueChange(it) })
                    // sign up button
                    Button(
                        onClick = { viewModel.onButtonPressed(onNavigate) }
                    ) {
                        Text(text = createAnAccountText)
                    }
                }
            }

            item {
                TextButton(onClick = {/* TODO: implement this*/}){
                    Text(text = alreadyHaveAnAccount)
                }
            }

            item {
                Divider(modifier = Modifier.padding(vertical = 20.dp))
            }

            item {
                Column {
                    CustomButton(
                        buttonText = continueWithGoogle,
                        iconId = R.drawable.ic_google,
                        onClick = { /*TODO*/ })

                    Spacer(modifier = Modifier.size(8.dp))

                    CustomButton(
                        buttonText = continueWithFacebook,
                        iconId = R.drawable.ic_facebook,
                        onClick = { /*TODO*/ })

                    Spacer(modifier = Modifier.size(8.dp))

                    CustomButton(
                        buttonText = continueWithApple,
                        iconId = R.drawable.ic_apple,
                        onClick = { /*TODO*/ })
                }
            }
        }
    }
}