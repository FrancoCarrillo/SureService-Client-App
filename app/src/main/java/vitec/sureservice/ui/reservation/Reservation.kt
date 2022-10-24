package vitec.sureservice.ui.reservation

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip

var  colorSureService1 = 0xFF0332FC

@Composable
fun Reservation(login: () -> Unit, requestAccept: ()-> Unit) {

    val btnEnabled = false

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally) {


        Card(elevation = 5.dp) {

            Column(modifier = Modifier.padding(15.dp)) {

                Row(verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painter = painterResource(id = R.drawable.technician_profile1),
                        contentDescription = "Image Technician Profile 1",
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                            .clip(CircleShape),
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Column {
                        Text(
                            text = "Alonso Perez",
                            style = TextStyle(color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                        )

                        Text(
                            text = "9/07/2022",
                            style = TextStyle(color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                        )
                    }
                }
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(15.dp))


                Row() {
                    Text(
                        text = "DETAIL: Se rompió la pantalla de mi celular",
                        style = TextStyle(color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    )

                }

                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp))


                Text(text = "ACCEPTED",
                    style = TextStyle(color = Color.Gray, fontSize = 20.sp, fontWeight = FontWeight.Bold),
                )

                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    TextButton(onClick = { requestAccept() }) {
                        Text(
                            text = "MORE INFO",
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color(colorSureService1)
                            ))
                    }
                }
            }
        }



        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(20.dp))


        Card(elevation = 5.dp) {

            Column(modifier = Modifier.padding(15.dp)) {

                Row(verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painter = painterResource(id = R.drawable.technician_profile2),
                        contentDescription = "Image Technician Profile 2",
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                            .clip(CircleShape),
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Column {
                        Text(
                            text = "Yolanda Poe",
                            style = TextStyle(color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                        )

                        Text(
                            text = "11/10/2022",
                            style = TextStyle(color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                        )
                    }
                }
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(15.dp))


                Row() {
                    Text(
                        text = "DETAIL: La bateria de mi celular se calienta mucho y esta empezando a hinchar",
                        style = TextStyle(color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    )

                }

                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp))


                Text(text = "WAITING",
                     style = TextStyle(color = Color.Gray, fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    )

                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    TextButton(onClick = { requestAccept() }, enabled = btnEnabled) {
                        Text(
                            text = "MORE INFO",
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color(colorSureService1)
                            ))
                    }
                }
            }
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(20.dp))


        Card(elevation = 5.dp) {

            Column(modifier = Modifier.padding(15.dp)) {

                Row(verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painter = painterResource(id = R.drawable.technician_profile3),
                        contentDescription = "Image Technician Profile 3",
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                            .clip(CircleShape),
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Column {
                        Text(
                            text = "Tanya Escobar",
                            style = TextStyle(color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                        )

                        Text(
                            text = "15/10/2022",
                            style = TextStyle(color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                        )
                    }
                }
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(15.dp))


                Row() {
                    Text(
                        text = "DETAIL: La entrada de mi tablet esta rota",
                        style = TextStyle(color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    )

                }

                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp))


                Text(text = "REJECTED",
                    style = TextStyle(color = Color.Gray, fontSize = 20.sp, fontWeight = FontWeight.Bold),
                )

                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    TextButton(onClick = { requestAccept() }, enabled = btnEnabled) {
                        Text(
                            text = "MORE INFO",
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color(colorSureService1)
                            ))
                    }
                }
            }
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp))
    }
}

/*
Waiting
Accept
Rejected
 */