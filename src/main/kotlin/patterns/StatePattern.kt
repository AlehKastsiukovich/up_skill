package patterns

enum class UserState(
    val signUp: (user: User, email: String) -> Unit,
    val verifyEmail: (user: User, token: String) -> Unit
) {
    ANONYMOUS(
        signUp = { user, email ->
            println("Signing up with email: $email")
            user.email = email
            user.state = UNVERIFIED
        },
        verifyEmail = { user, token ->
            println("You myst sign up before verifying your email.")
        }
    ),
    UNVERIFIED(
        signUp = { user, email ->
            println("You are already signed up")
        },
        verifyEmail = { user, token ->
            println("Verify email with token: $token")
            user.state = AUTHENTICATED
        }
    ),
    AUTHENTICATED(
        signUp = { user, email ->
            println("You are already signed up")
        },
        verifyEmail = { user, token ->
            println("You are already verified ")
        }
    )
}

class User(var email: String? = null, var state: UserState = UserState.ANONYMOUS) {
    fun signUp(email: String) = state.signUp(this, email)
    fun verifyEmail(token: String) = state.verifyEmail(this, token)
}

