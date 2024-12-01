package patterns

interface UserState {
    fun signUp(user: User, email: String)
    fun verifyEmail(user: User, token: String)
}

object Anonymous : UserState {
    override fun signUp(user: User, email: String) {
        println("Signing up with email: $email")
        user.email = email
        user.state = Unverified
    }

    override fun verifyEmail(user: User, token: String) = println("You myst sign up before verifying your email.")

}
object Unverified: UserState {
    override fun signUp(user: User, email: String) = println("You are already signed up")

    override fun verifyEmail(user: User, token: String) {
        println("Verify email with token: $token")
        user.state = Authenticated
    }
}

object Authenticated : UserState {
    override fun signUp(user: User, email: String) = println("You are already signed up")
    override fun verifyEmail(user: User, token: String) = println("You are already verified ")
}

class User(var email: String? = null, var state: UserState = Anonymous) {
    fun signUp(email: String) = state.signUp(this, email)
    fun verifyEmail(token: String) = state.verifyEmail(this, token)
}

