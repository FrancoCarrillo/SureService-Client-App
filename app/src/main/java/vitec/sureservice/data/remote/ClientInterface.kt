package vitec.sureservice.data.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import vitec.sureservice.data.model.Client
import vitec.sureservice.data.model.Technician
import vitec.sureservice.ui.login.LoginDto
import vitec.sureservice.ui.signup.SignupDto

interface ClientInterface {

    @POST("auth/sign-in")
    fun loginClient(@Body loginDto: LoginDto): Call<Client>

    @POST("clients/sign-up")
    fun signupClient(@Body signupDto: SignupDto): Call<Client>

}