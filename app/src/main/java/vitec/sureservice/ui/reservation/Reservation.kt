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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip

var  colorSureService1 = 0xFF0332FC

@Composable
fun Reservation(Logout: ()-> Unit, requestAccept: ()-> Unit) {

    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))

        OutlinedTextField(value = search, onValueChange = {search = it},
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            label = {Text(text = "Search")}
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(30.dp))


        Card(elevation = 5.dp) {

            Column() {

                Spacer(modifier = Modifier
                    .fillMaxWidth())

                Row(verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painter = painterResource(id = R.drawable.profile_img),
                        contentDescription = "Logo Image",
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .padding(15.dp)
                            .clip(CircleShape),
                    )
                    Column {
                        Text(
                            text = "Electric Service",
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
                    .height(5.dp))

                Row() {
                    
                    Spacer(modifier = Modifier.width(15.dp))

                    Text(
                        text = "REQUEST ACCEPTED",
                        style = TextStyle(color = Color.Gray, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    )
                }

                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp))

                Row() {

                    Spacer(modifier = Modifier.width(5.dp))
                    TextButton(onClick = { requestAccept() }) {
                        Text(
                            text = "MORE INFO",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium, color = Color(colorSureService1)
                        ))
                    }
                }



            }

        }
        
    }
}