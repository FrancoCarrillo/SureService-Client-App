package vitec.sureservice.ui.technicianProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import vitec.sureservice.data.model.Technician
import vitec.sureservice.ui.service.ServiceViewModel
import vitec.sureservice.ui.service.Valoration

@Composable
fun TechnicianProfile(technicianId: Int, serviceViewModel: ServiceViewModel, goToBookAnAppointment: (Int) -> Unit)
{
    val technician: Technician by serviceViewModel.technician.observeAsState(Technician())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 15.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = rememberImagePainter("https://www.maybelline-ma.com/~/media/mny/latam/panama/consejos-de-maquillaje/maquillaje-cara-cuadrada.jpg?h=735&w=735&la=es-PA&hash=6FA3888C30A756C0EE398F69EF0B215FBBA054A4"),
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = "${technician.name} ${technician.last_name}",
                    fontSize = 24.sp, fontWeight = FontWeight.Medium
                )
                Valoration(technician.valoration)
                Text(text = "Profession: ${technician.speciality.name}", fontSize = 14.sp)
                Text(text = "Location: ${technician.district}", fontSize = 14.sp)
            }
        }
        Button(
            onClick = { goToBookAnAppointment(technicianId) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "BOOK APPOINTMENT")
        }
        Text(
            text = "Description",
            fontSize = 24.sp, fontWeight = FontWeight.Medium
        )
        Text(text = "${technician.professional_profile}", fontSize = 14.sp)
    }
}

