package patterns

/**
 * Base problem: When you add a new state, all the functions will be broken.
 */

enum class UserState {
    ANONYMOUS,
    UNVERIFIED,
    AUTHENTICATED
}

class User(var email: String? = null, var state: UserState = UserState.ANONYMOUS) {
    fun signUp(email: String) {
        when(state) {
            UserState.ANONYMOUS -> {
                println("Signing up with email: $email")
                this.email = email
                state = UserState.UNVERIFIED
            }
            UserState.UNVERIFIED -> println("You are already signed up")
            UserState.AUTHENTICATED -> println("You are already signed up and authenticated")
        }
    }

    fun verifyEmail(token: String) {
        when(state) {
            UserState.ANONYMOUS -> {
                println("You myst sign up before verifying your email.")
            }
            UserState.UNVERIFIED -> {
                println("Verify email with token: $token")
                state = UserState.AUTHENTICATED
            }
            UserState.AUTHENTICATED -> println("You are already verified ")
        }
    }
}

