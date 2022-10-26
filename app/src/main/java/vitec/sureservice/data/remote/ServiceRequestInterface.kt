package vitec.sureservice.data.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import vitec.sureservice.data.model.ServiceRequest
import vitec.sureservice.ui.bookAnAppointment.ServiceRequestDto

interface ServiceRequestInterface {

    @POST("services/{clientId}/{technicianId}")
    fun postServiceRequest(@Path("clientId") clientId: Int, @Path("technicianId") technicianId: Int, @Body serviceRequestDto: ServiceRequestDto): Call<ServiceRequest>

    @GET("services/client/{clientId}")
    fun getServiceRequestByClientId(@Path("clientId") clientId: Int): Call<List<ServiceRequest>>


}