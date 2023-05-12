package com.mrjalal.monsterlabtesttask.signup.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mrjalal.monsterlabtesttask.R
import com.mrjalal.monsterlabtesttask.core.presentation.widget.CustomButton
import com.mrjalal.monsterlabtesttask.core.presentation.widget.CustomIcon
import com.mrjalal.monsterlabtesttask.core.presentation.widget.CustomTextField

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
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
    val emailAddress = stringResource(id = R.string.email_address)
    val password = stringResource(id = R.string.Password)

    val uiState = viewModel.uiState.collectAsState()

    val focusManager = LocalFocusManager.current
    val passwordTextFieldRef = remember { FocusRequester() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    CustomIcon(
                        iconId = R.drawable.ic_cross,
                        onClick = onCloseApp,
                        tintColor = MaterialTheme.colorScheme.tertiary
                    )
                },
                actions = { Text(text = laterText) },
            )
        },
        contentColor = MaterialTheme.colorScheme.background,
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 20.dp)
        ) {
            // title
            item {
                Spacer(modifier = Modifier.size(20.dp))
                Text(
                    text = createAnAccountText,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(60.dp))
            }

            item {
                Column {
                    // email text input
                    CustomTextField(
                        value = uiState.value.email,
                        onValueChange = { email -> viewModel.onEmailValueChange(email) },
                        modifier = Modifier.fillMaxWidth(),
                        hint = emailAddress,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Email
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = {
                                passwordTextFieldRef.requestFocus()
                            }
                        ),
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    // password text input
                    CustomTextField(
                        value = uiState.value.password,
                        onValueChange = { password -> viewModel.onPasswordValueChange(password) },
                        modifier = Modifier.fillMaxWidth().focusRequester(passwordTextFieldRef),
                        hint = password,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Password
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { focusManager.clearFocus() }
                        ),
                    )
                    Spacer(modifier = Modifier.size(40.dp))
                    // sign up button
                    CustomButton(
                        buttonText = createAnAccountText,
                        onClick = { viewModel.onButtonPressed(onNavigate) },
                        isEnable = uiState.value.isButtonEnable
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.requiredSize(20.dp))
                Box(modifier = Modifier.fillMaxWidth() ,contentAlignment = Alignment.Center) {
                    TextButton(onClick = {/* TODO: implement this*/ }) {
                        Text(
                            text = alreadyHaveAnAccount,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }

            item {
                Divider(modifier = Modifier.padding(vertical = 40.dp))
            }

            item {
                Column {
                    CustomButton(
                        buttonText = continueWithGoogle,
                        iconId = R.drawable.ic_google,
                        tintColor = MaterialTheme.colorScheme.secondary,
                        backgroundColor = Color.White,
                        onClick = { /*TODO*/ }
                    )

                    Spacer(modifier = Modifier.size(8.dp))

                    CustomButton(
                        buttonText = continueWithFacebook,
                        iconId = R.drawable.ic_facebook,
                        tintColor = MaterialTheme.colorScheme.secondary,
                        backgroundColor = Color.White,
                        onClick = { /*TODO*/ })

                    Spacer(modifier = Modifier.size(8.dp))

                    CustomButton(
                        buttonText = continueWithApple,
                        iconId = R.drawable.ic_apple,
                        tintColor = MaterialTheme.colorScheme.secondary,
                        backgroundColor = Color.White,
                        onClick = { /*TODO*/ })
                }
            }

            // bottom padding
            item {
                Spacer(modifier = Modifier.requiredSize(150.dp))
            }
        }
    }
}