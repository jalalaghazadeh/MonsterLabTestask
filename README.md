# MonsterSignUp

:zap: A simple but eloquent sample focused on Compose and MVVM+Clean architecture :zap:

## scenario

As a developer working on a sample app for a signup screen, my main focus is on showcasing the usage of Jetpack Compose and the MVVM architecture. However, I need to take into account the following business rules for the signup process:

- Email Validation: The email address entered by the user must contain the "@" symbol and a dot. Both the address and domain parts of the email should not be empty.

- Password Requirements: User passwords should be at least 8 characters long and should include a combination of letters and numbers.

- Button State: The "Create an account" button should only be enabled when the email and password meet the specified requirements.

- API Call Loading: During the API call, the button should be disabled, and optionally, a loading spinner can be displayed to indicate the ongoing process.

When the user taps the enabled "Create an account" button, the app should initiate an API call. Based on the response, the following scenarios need to be handled:

- Successful Response: If the API call is successful, the response will include a token in the format: ``` {"token": "SomeLongString"} ```. In this case, the app should navigate to another page, without considering the specific content of that page at this stage.

- Unsuccessful Response: If the API call fails and returns an HTTP status 403, an alert should be displayed to the user, indicating that an error occurred during the signup process.


## technologies

- Jetpack Compose
- MVVM+Clean
- Coroutine & Flows
- Hilt\Dagger
- Retrofit


## screen-shot
<br/>
<img src="https://github.com/jalalaghazadeh/MonsterSignUp/blob/main/screenshot/sign_up_screen.png" alt="signup" width="200" height="412">

