package vitec.sureservice.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import vitec.sureservice.data.model.Technician

interface TechnicianInterface {
    @GET("technician")
    fun getAllTechnicians(): Call<List<Technician>>

    @GET("technician/speciality/{specialityId}")
    fun getTechniciansBySpeciality(@Path("specialityId") specialityId: Int): Call<List<Technician>>

    @GET("technician/{id}")
    fun getTechnicianById(@Path("id") id: Int): Call<Technician>
}