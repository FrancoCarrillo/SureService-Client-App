package vitec.sureservice.data.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import vitec.sureservice.data.model.Client
import vitec.sureservice.ui.login.LoginDto

interface ClientInterface {

    @POST("auth/sign-in")
    fun loginClient(@Body loginDto: LoginDto): Call<Client>
}