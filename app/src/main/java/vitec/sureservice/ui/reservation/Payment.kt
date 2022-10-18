package vitec.sureservice.ui.reservation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Payment(paymentSuccess: ()-> Unit) {

    var cardNumber by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var securityCode by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp))  {

        Text(
            text = "Add Credit/Debid Card",
            style = TextStyle(color = Color.Black, fontSize = 38.sp, fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))

        OutlinedTextField(value = cardNumber, onValueChange = {cardNumber = it},
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            label = {Text(text = "Card Number")}
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))


        Row() {

            Column(        modifier = Modifier
                .height(70.dp),
                verticalArrangement = Arrangement.SpaceAround) {
                Text(
                    text = "Expirity",
                    style = TextStyle(color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Bold),
                )
            }

            Spacer(modifier = Modifier
                .width(15.dp))

            OutlinedTextField(value = month, onValueChange = {month = it},
                modifier = Modifier
                    .width(115.dp),
                singleLine = true,
                label = {Text(text = "MM")}
            )

            Spacer(modifier = Modifier
                .width(15.dp))

            OutlinedTextField(value = year, onValueChange = {year = it},
                modifier = Modifier
                    .width(115.dp),
                singleLine = true,
                label = {Text(text = "YY")}
            )
        }


        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))



        OutlinedTextField(value = securityCode, onValueChange = {securityCode = it},
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            label = {Text(text = "Security Code")}
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))


        OutlinedTextField(value = firstName, onValueChange = {firstName = it},
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            label = {Text(text = "First Name")}
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))


        OutlinedTextField(value = lastName, onValueChange = {lastName = it},
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            label = {Text(text = "Last Name")}
        )


        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(20.dp))

        Button(
            onClick = { paymentSuccess() },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(colorSureService2)),
        ) {
            Text(text = "PAY",
                style = TextStyle(color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Medium))
        }


        
    }

}