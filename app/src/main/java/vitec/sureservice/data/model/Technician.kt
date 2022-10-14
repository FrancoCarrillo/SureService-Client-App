package vitec.sureservice.data.model

class Technician(
    val id: Int,
    val name: String,
    val last_name: String,
    val telephone_number: String,
    val dni: String,
    val professional_profile: String,
    val valoration: Int,
    val district: String,
    val speciality: Speciality
) {
    constructor(): this(0,"","","","","",0,"", speciality = Speciality())
}