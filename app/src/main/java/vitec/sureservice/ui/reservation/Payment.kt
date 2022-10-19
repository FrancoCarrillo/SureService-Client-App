package vitec.sureservice.ui.reservation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Payment(paymentSuccess: ()-> Unit) {

    var cardNumber by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var securityCode by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }

    val btnEnabled = cardNumber.isNotEmpty() && month.isNotEmpty() && year.isNotEmpty() && securityCode.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty()


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

        OutlinedTextField(
            value = cardNumber,
            onValueChange = { if (it.length < 17) cardNumber = it },
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            label = { Text(text = "Card Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))


        Row() {

            Column(
                modifier = Modifier
                    .height(70.dp), verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Expirity",
                    style = TextStyle(color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Bold),
                )
            }

            Spacer(modifier = Modifier
                .width(15.dp))

            OutlinedTextField(
                value = month,
                onValueChange = { if (it.length < 3) month = it },
                modifier = Modifier
                    .width(115.dp),
                singleLine = true,
                label = { Text(text = "MM") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier
                .width(15.dp))

            OutlinedTextField(
                value = year,
                onValueChange = { if (it.length < 3) year = it },
                modifier = Modifier
                    .width(115.dp),
                singleLine = true,
                label = { Text(text = "YY") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }


        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))



        OutlinedTextField(
            value = securityCode,
            onValueChange = { if (it.length < 4) securityCode = it },
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            label = { Text(text = "Security Code") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
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
            onClick = { paymentSuccess() /* Payment Route */ },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(colorSureService2)),
            enabled = btnEnabled
        ) {
            Text(text = "PAY",
                style = TextStyle(color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Medium))
        }


        
    }

}