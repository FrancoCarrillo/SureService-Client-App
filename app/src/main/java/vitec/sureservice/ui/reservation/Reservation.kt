package vitec.sureservice.ui.reservation

import android.annotation.SuppressLint
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vitec.sureservice.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.draw.clip
import org.w3c.dom.Text
import vitec.sureservice.data.model.ServiceRequest

var  colorSureService1 = 0xFF0332FC

@SuppressLint("SuspiciousIndentation")
@Composable
fun Reservation(reservationViewModel: ReservationViewModel, requestAccept: (Int)-> Unit) {

    val serviceRequests: List<ServiceRequest> by reservationViewModel.serviceRequests.observeAsState(listOf())

        LazyColumn (modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            items(serviceRequests) { serviceRequest ->
                CardTechnicianService(serviceRequest, requestAccept)
            }

        }

}


@Composable
fun CardTechnicianService(serviceRequest: ServiceRequest, requestAccept: (Int)-> Unit) {

    val day = (1..28).random()
    val date = "$day-11-2022"

    Card(elevation = 5.dp) {
        Column(modifier = Modifier.padding(15.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(id = R.drawable.technician_profile1),
                    contentDescription = "Image Technician Profile 1",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                )
                Spacer(modifier = Modifier.width(15.dp))


                Column {
                    Text(
                        text = "${serviceRequest.technician.name} ${serviceRequest.technician.last_name}",
                        style = TextStyle(color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    )

                    Text(
                        text = date,
                        style = TextStyle(color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                    )
                }
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(15.dp))

            Row() {
                Text(
                    text = "ID: ",
                    style = TextStyle(color = Color.Black, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                )

                Text(
                    text = "${serviceRequest.id}",
                    style = TextStyle(color = Color.Black, fontSize = 14.sp, fontWeight = FontWeight.Medium)
                )

            }



            Row() {
                Text(
                    text = "DETAIL: ${serviceRequest.detail}",
                    style = TextStyle(color = Color.Black, fontSize = 14.sp, fontWeight = FontWeight.Medium)
                )
            }


            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(5.dp))


            if (serviceRequest.confirmation == 0) {
                    Text(text = "WAITING",
                        style = TextStyle( color = Color.Gray, fontSize = 16.sp, fontWeight = FontWeight.Bold))}


            if (serviceRequest.confirmation == 1) {
                Text(text = "ACCEPT",
                    style = TextStyle(color = Color(colorSureService1), fontSize = 16.sp, fontWeight = FontWeight.Bold))

                val btnEnabled = true

                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    TextButton(onClick = { requestAccept(serviceRequest.id) }, enabled = btnEnabled) {
                        Text(
                            text = "MORE INFO",
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color(colorSureService1)
                            ))
                    }
                }}

            if (serviceRequest.confirmation == 2) {
                Text(text = "REJECTED",
                    style = TextStyle(color = Color.Red, fontSize = 16.sp, fontWeight = FontWeight.Bold))}

            if (serviceRequest.confirmation == 3) {
                Text(text = "PAID OUT",
                    style = TextStyle(color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold))}

        }
    }

    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(5.dp))

}



/*
0 Waiting
1 Accept
2 Rejected
 */