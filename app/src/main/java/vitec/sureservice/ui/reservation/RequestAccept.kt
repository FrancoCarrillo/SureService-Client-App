package vitec.sureservice.ui.reservation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vitec.sureservice.R

var  colorSureService2 = 0xFF0332FC

@Composable
fun RequestAccept() {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp)) {

        Text(
            text = "Alan Perez",
            style = TextStyle(color = Color.Black, fontSize = 34.sp, fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))


        Row() {
            Text(
                text = "Selected Date: ",
                style = TextStyle(color = Color.Black, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            )

            Text(
                text = "7/9/2022",
                style = TextStyle(color = Color.Black, fontSize = 22.sp, fontWeight = FontWeight.Medium)
            )
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))


        Column() {
            Text(
                text = "Location: ",
                style = TextStyle(color = Color.Black, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            )

            Text(
                text = "Surco, Perú",
                style = TextStyle(color = Color.Black, fontSize = 22.sp, fontWeight = FontWeight.Medium)
            )
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))

        Column() {
            Text(
                text = "Message: ",
                style = TextStyle(color = Color.Black, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            )

            Text(
                text = "Hi! Pedro, Im glad to help you. I am going to visited at the selected date.",
                style = TextStyle(color = Color.Black, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            )
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.request_acepted),
                contentDescription = "Request Accept Image",
                modifier = Modifier
                    .height(300.dp)
                    .width(300.dp)
            )

            Text(
                text = "Ask the technician this ID when approaching your home",
                style = TextStyle(color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Medium)
            )

            Text(
                text = "12223",
                style = TextStyle(color = Color.Black, fontSize = 32.sp, fontWeight = FontWeight.Bold)
            )
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(30.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(colorSureService2)),
        ) {
            Text(text = "PAY",
                style = TextStyle(color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Medium))
        }
    }
}